package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Accommodation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccommodationServiceInterface {

    void createAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws BusinessException;

    void deleteAccommodation(int accommodationId) throws BusinessException;

    AccommodationDTO getAccommodationDTO(int accommodationId) throws BusinessException;

    Optional<Accommodation> getAccommodation(int accommodationId) throws BusinessException;

    List<AccommodationDTO> getAllAccommodations();
}
