package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;

    @RequestMapping("/create")
    public ResponseEntity<TimeSheetDTO> createTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws ParseException {
        timeSheetService.createTimeSheet(timeSheetDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping("/update")
    public ResponseEntity<TimeSheetDTO> updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws EntityNotFoundException {
        return new ResponseEntity<>(timeSheetService.updateTimeSheet(timeSheetDTO), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{timeSheetId}")
    public ResponseEntity<TimeSheetDTO> deleteTimeSheet(@PathVariable int timeSheetId) throws EntityNotFoundException {
        timeSheetService.deleteTimeSheet(timeSheetId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{timeSheetId}")
    public ResponseEntity<TimeSheetDTO> getTimeSheet(@PathVariable int timeSheetId) throws EntityNotFoundException {
        return new ResponseEntity<>(timeSheetService.getTimeSheetDTO(timeSheetId), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get-all")
    public ResponseEntity<List<TimeSheetDTO>> showAllTimeSheets(Model model) {
        return new ResponseEntity<>(timeSheetService.getAllTimeSheets(), HttpStatus.OK);
    }


}
