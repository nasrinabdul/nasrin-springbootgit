package org.example.springProject.service;

import org.example.springProject.data.Employee;
import org.example.springProject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Optional<Employee> getEmployee(long employeeId) {
        //Employee employee = getDummyEmployee(employeeId);
        return employeeRepository.findById(employeeId);

    }

    public List<Employee> getEmployeeByName(String empName) {
        List<Optional<Employee>> empList = employeeRepository.findByEmployeeName(empName);
        return empList.stream().map(Optional::get).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveOrUpdate(Employee employee, HashMap<Long, Employee> employeeMap) {

       // Optional<Long> latestEmpId = employeeMap.keySet().stream()
         //       .sorted((key1, key2) ->  key2.compareTo(key1)).findFirst();
        //employee.setEmployeeId(latestEmpId.orElse((long)0)+1);
        employee = employeeRepository.save(employee);

        //employeeMap.put(employee.getEmployeeId(), employee);
        return employee;
    }

    public void delEmployee(List<Long> empId) {
        employeeRepository.deleteAllById(empId);
    }
    private Employee getDummyEmployee(long employeeId) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeId);
        employee.setEmployeeName("Tester");
       // employee.setEmployeeDOB(new Date(1982,7,31));
        //employee.setJoiningDate(new Date(2004,4,16));
        employee.setEmailId("tester@abc.com");
        return employee;
    }
}
