package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.JobPositionDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.JobPosition;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface JobPositionServiceInterface {
    void createJobPosition(JobPositionDTO jobPositionDTO);

    JobPositionDTO updateJobPosition(JobPositionDTO jobPositionDTO) throws EntityNotFoundException;

    void deleteJobPosition(int jobPositionId) throws EntityNotFoundException;

    Optional<JobPosition> getJobPosition(int jobPositionId) throws EntityNotFoundException;

    JobPositionDTO getJobPositionDTO(int jobPositionId) throws EntityNotFoundException;
}