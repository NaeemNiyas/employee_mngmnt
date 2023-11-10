package com.williamslea.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.williamslea.employeemanagement.model.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
    
}
