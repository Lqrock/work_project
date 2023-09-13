package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServiceInterface {

    void createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws BusinessException;

    void deleteEmployee(int employeeId) throws BusinessException;

    EmployeeDTO getEmployeeDTO(int employeeId) throws BusinessException;

    Optional<Employee> getEmployee(int employeeId) throws BusinessException;

    List<EmployeeDTO> getAllAccommodations();
}
