package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.PhoneNumberDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phonenumber")
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @PostMapping("/create")
    public ResponseEntity<PhoneNumberDTO> createPhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO) {
        phoneNumberService.createPhoneNumber(phoneNumberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PhoneNumberDTO> updatePhoneNumber(@RequestBody PhoneNumberDTO phoneNumberDTO) throws EntityNotFoundException {
        phoneNumberService.updatePhoneNumber(phoneNumberDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{phoneNumberId}")
    public ResponseEntity<PhoneNumberDTO> deletePhoneNumber(@PathVariable int phoneNumberId) throws EntityNotFoundException {
        phoneNumberService.deletePhoneNumber(phoneNumberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{phoneNumberId}")
    public ResponseEntity<PhoneNumberDTO> getPhoneNumber(@PathVariable int phoneNumberId) throws EntityNotFoundException {
        return new ResponseEntity<>(phoneNumberService.getPhoneNumberDTO(phoneNumberId), HttpStatus.OK);
    }
}
