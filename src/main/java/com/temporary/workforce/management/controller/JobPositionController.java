package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.JobPositionDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    public ResponseEntity<JobPositionDTO> updateJobPosition(@RequestBody JobPositionDTO jobPositionDTO) throws EntityNotFoundException {
        jobPositionService.updateJobPosition(jobPositionDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{jobPositionId}")
    public ResponseEntity<JobPositionDTO> deleteJobPosition(@PathVariable int jobPositionId) throws EntityNotFoundException {
        jobPositionService.deleteJobPosition(jobPositionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{jobPositionId}")
    public ResponseEntity<JobPositionDTO> getJobPosition(@PathVariable int jobPositionId) throws EntityNotFoundException {
        return new ResponseEntity<>(jobPositionService.getJobPositionDTO(jobPositionId), HttpStatus.OK);
    }
}
