package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByEmail(String email);
}
