package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VehicleServiceInterface {

    void createVehicle(VehicleDTO vehicleDTO);

    VehicleDTO updateVehicle(VehicleDTO vehicleDTO) throws BusinessException;

    void deleteVehicle(int vehicleId) throws BusinessException;

    Optional<Vehicle> getVehicle(int vehicleId) throws BusinessException;

    VehicleDTO getVehicleDTO(int vehicleId) throws BusinessException;

    List<VehicleDTO> getAllVehicles();

    List<VehicleDTO> getAllAccommodations();
}
