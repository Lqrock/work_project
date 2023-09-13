package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.dto.TimeSheetDTO;
import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<TimeSheetDTO> updateTimeSheet(@RequestBody TimeSheetDTO timeSheetDTO) throws BusinessException {
        return new ResponseEntity<>(timeSheetService.updateTimeSheet(timeSheetDTO), HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{timeSheetId}")
//    public ResponseEntity<TimeSheetDTO> deleteTimeSheet(@PathVariable int timeSheetId) throws BusinessException {
//        timeSheetService.deleteTimeSheet(timeSheetId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/get/{timeSheetId}")
    public ResponseEntity<TimeSheetDTO> getTimeSheet(@PathVariable int timeSheetId) throws BusinessException {
        return new ResponseEntity<>(timeSheetService.getTimeSheetDTO(timeSheetId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public String showAllTimeSheets(Model model) {
        List<TimeSheetDTO> timeSheetDTOList = timeSheetService.getAllTimeSheets();
        model.addAttribute("timeSheets", timeSheetDTOList);
        return "show-all-timesheets";
    }

    @GetMapping("/delete/{timeSheetId}")
    public String deleteTimesheet(@PathVariable int timeSheetId) throws BusinessException {
        timeSheetService.deleteTimeSheet(timeSheetId);
        return "redirect:/timesheet/get-all";
    }

    @GetMapping("/register")
    public String showVehicleForm(Model model) {
        TimeSheetDTO timeSheetDTO = new TimeSheetDTO();
        model.addAttribute("timesheet", timeSheetDTO);
        return "create-timesheet";
    }

    @PostMapping("/register")
    public String registerVehicle(Model model, @ModelAttribute("timesheet") TimeSheetDTO timeSheetDTO) throws ParseException {
        timeSheetService.createTimeSheet(timeSheetDTO);
        return "redirect:/timesheet/get-all";
    }

}
