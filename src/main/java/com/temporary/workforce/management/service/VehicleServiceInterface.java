package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VehicleServiceInterface {

    void createVehicle(VehicleDTO vehicleDTO);

    VehicleDTO updateVehicle(VehicleDTO vehicleDTO) throws EntityNotFoundException;

    void deleteVehicle(int vehicleId) throws EntityNotFoundException;

    Optional<Vehicle> getVehicle(int vehicleId) throws EntityNotFoundException;

    VehicleDTO getVehicleDTO(int vehicleId) throws EntityNotFoundException;

    List<VehicleDTO> getAllVehicles();

    List<VehicleDTO> getAllAccommodations();
}
