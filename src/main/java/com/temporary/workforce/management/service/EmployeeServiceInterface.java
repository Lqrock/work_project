package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServiceInterface {

    EmployeeDTO getEmployeeByEmail(String employeeEmail) throws EntityNotFoundException;

    void createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException;

    void deleteEmployee(int employeeId) throws EntityNotFoundException;

    EmployeeDTO getEmployeeDTO(int employeeId) throws EntityNotFoundException;

    Optional<Employee> getEmployee(int employeeId) throws EntityNotFoundException;

    List<EmployeeDTO> getAllAccommodations();
}
