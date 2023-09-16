package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Accommodation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccommodationServiceInterface {

    void createAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws EntityNotFoundException;

    void deleteAccommodation(int accommodationId) throws EntityNotFoundException;

    AccommodationDTO getAccommodationDTO(int accommodationId) throws EntityNotFoundException;

    Optional<Accommodation> getAccommodation(int accommodationId) throws EntityNotFoundException;

    List<AccommodationDTO> getAllAccommodations();
}
