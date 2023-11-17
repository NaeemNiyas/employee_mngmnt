package com.williamslea.employee_management;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.williamslea.employee_management.model.Employee;
import com.williamslea.employee_management.repository.EmployeeRepo;
import com.williamslea.employee_management.serviceIMPL.EmployeeServiceImpl;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void addEmployee_ShouldSaveEmployee_WhenCalled() {
        // Arrange
        var employee = new Employee();
        when(employeeRepo.save(employee)).thenReturn(employee);

        // Act
        var result = employeeService.addEmployee(employee);

        // Assert
        assertEquals(employee, result);
        verify(employeeRepo, times(1)).save(employee);
    }

    @Test
    void removeEmployee_ShouldDeleteEmployeeById_WhenCalled() {
        // Arrange
        var id = 1;

        // Act
        employeeService.removeEmployee(id);

        // Assert
        verify(employeeRepo, times(1)).deleteById(id);
    }

    @Test
    void findEmployeeById_ShouldReturnEmployee_WhenEmployeeExists() {
        // Arrange
        var id = 1;
        var employee = new Employee();
        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        // Act
        var result = employeeService.findEmpById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
        verify(employeeRepo, times(1)).findById(id);
    }

    @Test
    void findEmployeeById_ShouldReturnEmptyOptional_WhenEmployeeDoesNotExist() {
        // Arrange
        var id = 1;
        when(employeeRepo.findById(id)).thenReturn(Optional.empty());

        // Act
        var result = employeeService.findEmpById(id);

        // Assert
        assertTrue(result.isEmpty());
        verify(employeeRepo, times(1)).findById(id);
    }

    @Test
    void getAllEmployee_ShouldReturnListOfEmployees() {
        // Arrange
        var employees = Arrays.asList(new Employee(), new Employee());
        when(employeeRepo.findAll()).thenReturn(employees);

        // Act
        var result = employeeService.getAllEmployee();

        // Assert
        assertEquals(employees.size(), result.size());
        assertEquals(employees, result);
        verify(employeeRepo, times(1)).findAll();
    }
}

