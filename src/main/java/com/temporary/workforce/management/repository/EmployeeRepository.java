package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmailIgnoreCase(String employeeEmail);
}
