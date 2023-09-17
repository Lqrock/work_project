package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) throws EntityNotFoundException {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{vehicleId}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable int vehicleId) throws EntityNotFoundException {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{vehicleId}")
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable int vehicleId) throws EntityNotFoundException {
        return new ResponseEntity<>(vehicleService.getVehicleDTO(vehicleId), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get-all")
    public ResponseEntity<List<VehicleDTO>> showAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllAccommodations(), HttpStatus.OK);
    }

}
