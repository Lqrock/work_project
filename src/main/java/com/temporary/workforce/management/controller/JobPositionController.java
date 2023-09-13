package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.JobPositionDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jobposition")
public class JobPositionController {

    @Autowired
    JobPositionService jobPositionService;

    @PostMapping("/create")
    public ResponseEntity<JobPositionDTO> createJobPosition(@RequestBody JobPositionDTO jobPositionDTO) {
        jobPositionService.createJobPosition(jobPositionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<JobPositionDTO> updateJobPosition(@RequestBody JobPositionDTO jobPositionDTO) throws BusinessException {
        jobPositionService.updateJobPosition(jobPositionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{jobPositionId}")
    public ResponseEntity<JobPositionDTO> deleteJobPosition(@PathVariable int jobPositionId) throws BusinessException {
        jobPositionService.deleteJobPosition(jobPositionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{jobPositionId}")
    public ResponseEntity<JobPositionDTO> getJobPosition(@PathVariable int jobPositionId) throws BusinessException {
        return new ResponseEntity<>(jobPositionService.getJobPositionDTO(jobPositionId), HttpStatus.OK);
    }
}
