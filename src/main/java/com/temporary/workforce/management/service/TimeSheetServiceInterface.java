package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.TimeSheet;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public interface TimeSheetServiceInterface {

    void createTimeSheet(TimeSheetDTO timeSheetDTO) throws ParseException;

    TimeSheetDTO updateTimeSheet(TimeSheetDTO timeSheetDTO) throws EntityNotFoundException;

    void deleteTimeSheet(int timeSheetId) throws EntityNotFoundException;

    TimeSheetDTO getTimeSheetDTO(int timeSheetId) throws EntityNotFoundException;

    Optional<TimeSheet> getTimeSheet(int timeSheetId) throws EntityNotFoundException;

    List<TimeSheetDTO> getAllTimeSheets();
}
