package com.williamslea.employee_management.serviceIMPL;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamslea.employee_management.model.Employee;
import com.williamslea.employee_management.repository.EmployeeRepo;
import com.williamslea.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        var emp = employeeRepo.save(employee);
        return emp;
    }

    @Override
    public String removeEmployee(int id) {
        employeeRepo.deleteById(id);
        return "Delete Successful";
    }

    @Override
    public Optional<Employee> findEmpById(int id) {
        var emp = employeeRepo.findById(id);
        return emp.isPresent() ? emp : Optional.empty();
    }

    @Override
    public List<Employee> getAllEmployee() {
        var empList = employeeRepo.findAll();
        return empList;
    }

    @Override
    public String updateEmployee(int id) {
        var emp = employeeRepo.findById(id);
        if (emp.isPresent()) {
            var emps = new Employee();
            employeeRepo.save(emps);
            return "Employee Record Updated Successfully";
        } else {
            return "Employee Not Found";
        }
    }
}

