package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.error_controller.GlobalExceptionHandler;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.OwnershipType;
import com.temporary.workforce.management.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController extends GlobalExceptionHandler {

    @Autowired
    AccommodationService accommodationService;


    @PostMapping("/create")
    public ResponseEntity<AccommodationDTO> createAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        accommodationService.createAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AccommodationDTO> updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) throws EntityNotFoundException {
        accommodationService.updateAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{accommodationId}")
    public ResponseEntity<AccommodationDTO> deleteAccommodation(@PathVariable int accommodationId) throws EntityNotFoundException {
        accommodationService.deleteAccommodation(accommodationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Transactional(readOnly = true)
    @GetMapping("/get/{accommodationId}")
    public ResponseEntity<AccommodationDTO> getAccommodation(@PathVariable int accommodationId) throws EntityNotFoundException {
        return new ResponseEntity<>(accommodationService.getAccommodationDTO(accommodationId), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get-all")
    public ResponseEntity<List<AccommodationDTO>> showAllAccommodations() {
        List<AccommodationDTO> accommodationDTOList = accommodationService.getAllAccommodations();
        return new ResponseEntity<>(accommodationDTOList, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get-by-ownership-type/{ownershipType}")
    public ResponseEntity<List<AccommodationDTO>> getAccommodationByOwnershipType(@PathVariable OwnershipType ownershipType) throws EntityNotFoundException {
        return new ResponseEntity<>(accommodationService.getAccommodationsDTOByOwnershipType(ownershipType), HttpStatus.OK);
    }
}
