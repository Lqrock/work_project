package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) throws BusinessException {
        employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable int employeeId) throws BusinessException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int employeeId) throws BusinessException {
        return new ResponseEntity<>(employeeService.getEmployeeDTO(employeeId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDTO>> showAllEmployees() {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllAccommodations();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

}
