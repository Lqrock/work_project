package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.EmailDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<EmailDTO> createEmail(@RequestBody EmailDTO emailDTO) {
        emailService.createEmail(emailDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<EmailDTO> updateEmail(@RequestBody EmailDTO emailDTO) throws EntityNotFoundException {
        emailService.updateEmail(emailDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<EmailDTO> deleteEmail(@PathVariable int emailId) throws EntityNotFoundException {
        emailService.deleteEmail(emailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{emailId}")
    public ResponseEntity<EmailDTO> getEmail(@PathVariable int emailId) throws EntityNotFoundException {
        return new ResponseEntity<>(emailService.getEmailDTO(emailId), HttpStatus.OK);
    }


}
