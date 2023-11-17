package com.williamslea.employee_management.service;
import java.util.List;
import java.util.Optional; 
import com.williamslea.employee_management.model.Employee;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);
    public String removeEmployee(int id);
    public Optional<Employee> findEmpById(int id);
    public List<Employee> getAllEmployee();
    public String updateEmployee(int id);

}
