package com.williamslea.employee_management.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.williamslea.employee_management.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
    
}
