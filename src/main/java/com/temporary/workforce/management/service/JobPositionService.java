package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.JobPositionDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.JobPosition;
import com.temporary.workforce.management.repository.JobPositionRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobPositionService implements JobPositionServiceInterface {

    @Autowired
    private JobPositionRepository jobPositionRepository;

    Logger logger = LoggerFactory.getLogger(JobPositionService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createJobPosition(JobPositionDTO jobPositionDTO) {
        JobPosition jobPosition = modelMapper.map(jobPositionDTO, JobPosition.class);
        jobPositionRepository.save(jobPosition);
        logger.info("JobPosition Created Successfully");
    }

    @Override
    public JobPositionDTO updateJobPosition(JobPositionDTO jobPositionDTO) throws EntityNotFoundException {
        logger.info("Updating JobPosition {}", jobPositionDTO.getId());
        Optional<JobPosition> existingJobPositionOpt = jobPositionRepository.findById(jobPositionDTO.getId());
        throwExceptionIfJobPositionNotFound(existingJobPositionOpt, jobPositionDTO.getId());
        JobPosition existingJobPosition = modelMapper.map(jobPositionDTO, JobPosition.class);

        jobPositionRepository.save(existingJobPosition);
        logger.info("JobPosition updated");
        return modelMapper.map(existingJobPosition, JobPositionDTO.class);
    }

    @Override
    public void deleteJobPosition(int jobPositionId) throws EntityNotFoundException {
        logger.info("Deleting JobPosition");
        Optional<JobPosition> jobPosition = jobPositionRepository.findById(jobPositionId);
        throwExceptionIfJobPositionNotFound(jobPosition, jobPositionId);
        jobPositionRepository.deleteById(jobPositionId);
        logger.info("JobPosition deleted");
    }

    @Override
    public Optional<JobPosition> getJobPosition(int jobPositionId) throws EntityNotFoundException {
        logger.info("Retrieving JobPosition");
        Optional<JobPosition> jobPosition = jobPositionRepository.findById(jobPositionId);
        throwExceptionIfJobPositionNotFound(jobPosition, jobPositionId);
        return jobPosition;
    }

    @Override
    public JobPositionDTO getJobPositionDTO(int jobPositionId) throws EntityNotFoundException {
        logger.info("Retrieving JobPositionDTO");
        Optional<JobPosition> jobPosition = jobPositionRepository.findById(jobPositionId);
        throwExceptionIfJobPositionNotFound(jobPosition, jobPositionId);
        return modelMapper.map(jobPosition, JobPositionDTO.class);
    }

    private void throwExceptionIfJobPositionNotFound(Optional<JobPosition> jobPosition, int jobPositionId) throws EntityNotFoundException {
        if (jobPosition.isEmpty()) {
            throw new EntityNotFoundException("Accommodation with ID " + jobPositionId + " not found.");
        }
    }
}
