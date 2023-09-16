package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.PhoneNumberDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PhoneNumberServiceInterface {

    void createPhoneNumber(PhoneNumberDTO phoneNumberDTO);

    PhoneNumberDTO updatePhoneNumber(PhoneNumberDTO phoneNumberDTO) throws EntityNotFoundException;

    void deletePhoneNumber(int phoneNumberId) throws EntityNotFoundException;

    Optional<PhoneNumber> getPhoneNumber(int phoneNumberId) throws EntityNotFoundException;

    PhoneNumberDTO getPhoneNumberDTO(int phoneNumberId) throws EntityNotFoundException;
}
