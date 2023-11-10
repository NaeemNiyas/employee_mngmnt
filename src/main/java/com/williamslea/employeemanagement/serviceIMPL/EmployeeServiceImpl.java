package com.williamslea.employeemanagement.serviceIMPL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.williamslea.employeemanagement.model.Employee;
import com.williamslea.employeemanagement.repository.EmployeeRepo;
import com.williamslea.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp=employeeRepo.save(employee);
        return emp;
        // throw new UnsupportedOperationException("Unimplemented method 'addEmployee'");
    }

    @Override
    public String removeEmployee(int id) {
       employeeRepo.deleteById(id);
        return "Delete Successfull";
        // throw new UnsupportedOperationException("Unimplemented method 'removeEmployee'");
    }

    @Override
    public Optional<Employee> findEmpById(int id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if(emp.isPresent())
        {
            return emp;
        }
        else
        {
            return null;
        }
        
        // throw new UnsupportedOperationException("Unimplemented method 'findEmpById'");
    }

    @Override
    public List<Employee> getAllEmployee() {
       
        List<Employee> empList= employeeRepo.findAll();
        return empList;
        // throw new UnsupportedOperationException("Unimplemented method 'getAllEmployee'");
    }

    @Override
    public String updateEmployee(int id) {

            Optional<Employee> emp=employeeRepo.findById(id);
            if(emp.isPresent())
            {
                Employee emps= new Employee();
                employeeRepo.save(emps);
                return "Employee Record Updated Sucessfully";

            }  
            else
            {
                return "Employee Not Found";
            }   
            // throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }
    
}
