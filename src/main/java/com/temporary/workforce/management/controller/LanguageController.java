package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.LanguageDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @PostMapping("/create")
    public ResponseEntity<LanguageDTO> createLanguage(@RequestBody LanguageDTO languageDTO) {
        languageService.createLanguage(languageDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LanguageDTO> updateLanguage(@RequestBody LanguageDTO languageDTO) throws EntityNotFoundException {
        languageService.updateLanguage(languageDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{languageId}")
    public ResponseEntity<LanguageDTO> deleteLanguage(@PathVariable int languageId) throws EntityNotFoundException {
        languageService.deleteLanguage(languageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{languageId}")
    public ResponseEntity<LanguageDTO> getLanguage(@PathVariable int languageId) throws EntityNotFoundException {
        return new ResponseEntity<>(languageService.getLanguageDTO(languageId), HttpStatus.OK);
    }
}
