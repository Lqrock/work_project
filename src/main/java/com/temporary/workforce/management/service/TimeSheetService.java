package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.TimeSheet;
import com.temporary.workforce.management.repository.TimeSheetRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService implements TimeSheetServiceInterface {

    @Autowired
    TimeSheetRepository timeSheetRepository;

    Logger logger = LoggerFactory.getLogger(TimeSheetService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createTimeSheet(TimeSheetDTO timeSheetDTO) throws ParseException {
        logger.info("Creating time sheet");
        timeSheetDTO.setStartingTime(timeSheetDTO.getStartingTime().concat(":00"));
        timeSheetDTO.setFinishingTime(timeSheetDTO.getFinishingTime().concat(":00"));
        TimeSheet timeSheet = modelMapper.map(timeSheetDTO, TimeSheet.class);
        timeSheetRepository.save(timeSheet);
        logger.info("Time sheet created");
    }

    @Override
    public TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) throws EntityNotFoundException {
        logger.info("Updating time sheet");
        Optional<TimeSheet> existingTimeSheetOpt = timeSheetRepository.findById(timeSheetDTO.getId());
        throwExceptionIfTimeSheetNotFound(existingTimeSheetOpt, timeSheetDTO.getId());
        TimeSheet existingTimeSheet = modelMapper.map(timeSheetDTO, TimeSheet.class);
        if (existingTimeSheetOpt.isPresent() && existingTimeSheetOpt.get().getEmployee() != null) {
            existingTimeSheet.setEmployee(existingTimeSheetOpt.get().getEmployee());
        }
        if (existingTimeSheetOpt.isPresent() && existingTimeSheetOpt.get().getJobPosition() != null) {
            existingTimeSheet.setJobPosition(existingTimeSheetOpt.get().getJobPosition());
        }
        timeSheetRepository.save(existingTimeSheet);
        return modelMapper.map(existingTimeSheet, TimeSheetDTO.class);
    }

    @Override
    public void deleteTimeSheet(int timeSheetId) throws EntityNotFoundException {
        logger.info("Deleting time sheet");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        timeSheetRepository.deleteById(timeSheetId);
        logger.info("Deleted time sheet");
    }

    @Override
    public TimeSheetDTO getTimeSheetDTO(int timeSheetId) throws EntityNotFoundException {
        logger.info("Retrieving timeSheetDTO");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        return modelMapper.map(timeSheet, TimeSheetDTO.class);
    }

    @Override
    public Optional<TimeSheet> getTimeSheet(int timeSheetId) throws EntityNotFoundException {
        logger.info("Retrieving time sheet");
        Optional<TimeSheet> timeSheet = timeSheetRepository.findById(timeSheetId);
        throwExceptionIfTimeSheetNotFound(timeSheet, timeSheetId);
        return timeSheet;
    }

    @Override
    public List<TimeSheetDTO> getAllTimeSheets() {
        List<TimeSheet> timeSheets = timeSheetRepository.findAll();
        List<TimeSheetDTO> timeSheetDTOList = new ArrayList<>();
        if (!timeSheets.isEmpty()) {
            timeSheets.forEach(timeSheet -> timeSheetDTOList.add(modelMapper.map(timeSheet, TimeSheetDTO.class)));
        }
        return timeSheetDTOList;
    }

    void throwExceptionIfTimeSheetNotFound(Optional<TimeSheet> timeSheet, int timeSheetId) throws EntityNotFoundException {
        if (timeSheet.isEmpty()) {
            throw new EntityNotFoundException("Time sheet with id " + timeSheetId + " not found");
        }
    }


}
