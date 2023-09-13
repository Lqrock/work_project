package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;


    @Transactional
    @PostMapping("/create")
    public ResponseEntity<AccommodationDTO> createAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        accommodationService.createAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AccommodationDTO> updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) throws BusinessException {
        accommodationService.updateAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{accommodationId}")
    public ResponseEntity<AccommodationDTO> deleteAccommodation(@PathVariable int accommodationId) throws BusinessException {
        accommodationService.deleteAccommodation(accommodationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{accommodationId}")
    public ResponseEntity<AccommodationDTO> getAccommodation(@PathVariable int accommodationId) throws BusinessException {
        return new ResponseEntity<>(accommodationService.getAccommodationDTO(accommodationId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AccommodationDTO>> showAllAccommodations() {
        List<AccommodationDTO> accommodationDTOList = accommodationService.getAllAccommodations();
        return new ResponseEntity<>(accommodationDTOList, HttpStatus.OK);
    }

}
