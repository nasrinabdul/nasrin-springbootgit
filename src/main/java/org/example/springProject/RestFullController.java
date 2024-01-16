package org.example.springProject;

import org.example.springProject.data.Employee;
import org.example.springProject.data.EmployeeWeb;
import org.example.springProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class RestFullController {

    private final EmployeeService employeeService;
    private final HashMap<Long, Employee> employeeMap = new HashMap<>();

    RestFullController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/emp/empId={empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable long empId) {
        //Employee employee = employeeMap.getOrDefault(empId, employeeService.getEmployee(empId));
        Optional<Employee> employee = employeeService.getEmployee(empId);
        if(employee.isPresent()) {
            return new ResponseEntity<Employee>(employeeService.getEmployee(empId).get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Employee not found", HttpStatus.OK);
    }

    @GetMapping("/emp/empName={empName}")
    public ResponseEntity<List> getEmployeeByName(@PathVariable String empName) {
        //List<Employee> employeeList = employeeMap.values().stream()
          //      .filter((Employee emp)->emp.getEmployeeName().equals(empName)).toList();

        return new ResponseEntity<List>(employeeService.getEmployeeByName(empName), HttpStatus.OK);
    }

    @GetMapping("/emp/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/emp/delete/empId={empId}")
    public ResponseEntity<String> delEmployeeById(@PathVariable long empId) {

       // Employee emp = employeeMap.remove(empId);
        try {
            employeeService.delEmployee(List.of(empId));
        }
        catch(Exception se) {
            se.printStackTrace();
            return new ResponseEntity<String>("Employee Not Deleted", HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
    }

    @PostMapping(value="/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        employee = employeeService.saveOrUpdate(employee, employeeMap);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }
}

