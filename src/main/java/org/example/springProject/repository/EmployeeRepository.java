package org.example.springProject.repository;

import org.example.springProject.data.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     List<Optional<org.example.springProject.data.Employee>> findByEmployeeName(String employeeName);
}
