package com.williamslea.employee_management.controller;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.williamslea.employee_management.model.Employee;
import com.williamslea.employee_management.serviceIMPL.EmployeeServiceImpl;

    @RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl empservice;


    @GetMapping("/home")
    public String homePage()
    {
        return "Welocme To Employee Management System";
    }

    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        var emp = empservice.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id) {
        empservice.removeEmployee(id);
        return new ResponseEntity<>("Remove Successful", HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id) {
        var emps = empservice.findEmpById(id);
        return new ResponseEntity<>(emps, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> listOfEmployees() {
        var lEmp = empservice.getAllEmployee();
        return new ResponseEntity<>(lEmp, HttpStatus.ACCEPTED);
    }
    
}

