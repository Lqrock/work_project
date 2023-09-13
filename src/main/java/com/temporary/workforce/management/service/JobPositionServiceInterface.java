package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.JobPositionDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.JobPosition;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface JobPositionServiceInterface {
    void createJobPosition(JobPositionDTO jobPositionDTO);

    JobPositionDTO updateJobPosition(JobPositionDTO jobPositionDTO) throws BusinessException;

    void deleteJobPosition(int jobPositionId) throws BusinessException;

    Optional<JobPosition> getJobPosition(int jobPositionId) throws BusinessException;

    JobPositionDTO getJobPositionDTO(int jobPositionId) throws BusinessException;
}