package com.williamslea.employee_management;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.williamslea.employee_management.controller.EmployeeController;
import com.williamslea.employee_management.model.Employee;
import com.williamslea.employee_management.serviceIMPL.EmployeeServiceImpl;

import java.util.List;  
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void testAddEmployee() {
        Employee employee = new Employee();
        when(employeeService.addEmployee(employee)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.addEmployee(employee);

        assertAll(
            () -> assertEquals(HttpStatus.CREATED, response.getStatusCode()),
            () -> assertEquals(employee, response.getBody())
        );
        verify(employeeService, times(1)).addEmployee(employee);
    }

    @Test
    void testRemoveEmployee() {
        int id = 1;
        ResponseEntity<String> response = employeeController.removeEmployee(id);

        assertAll(
            () -> assertEquals(HttpStatus.ACCEPTED, response.getStatusCode()),
            () -> assertEquals("Remove Successful", response.getBody())
        );
        verify(employeeService, times(1)).removeEmployee(id);
    }

    @Test
    void testFindEmployeeById() {
        int id = 1;
        Employee employee = new Employee();
        when(employeeService.findEmpById(id)).thenReturn(Optional.of(employee));

        ResponseEntity<Optional<Employee>> response = employeeController.findEmployeeById(id);

        assertAll(
            () -> assertEquals(HttpStatus.ACCEPTED, response.getStatusCode()),
            () -> assertEquals(Optional.of(employee), response.getBody())
        );
        verify(employeeService, times(1)).findEmpById(id);
    }

    @Test
    void testListOfEmployees() {
        ResponseEntity<List<Employee>> response = employeeController.listOfEmployees();

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        verify(employeeService, times(1)).getAllEmployee();
    }
}

