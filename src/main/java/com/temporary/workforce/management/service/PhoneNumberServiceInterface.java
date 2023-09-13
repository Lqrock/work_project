package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.PhoneNumberDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PhoneNumberServiceInterface {

    void createPhoneNumber(PhoneNumberDTO phoneNumberDTO);

    PhoneNumberDTO updatePhoneNumber(PhoneNumberDTO phoneNumberDTO) throws BusinessException;

    void deletePhoneNumber(int phoneNumberId) throws BusinessException;

    Optional<PhoneNumber> getPhoneNumber(int phoneNumberId) throws BusinessException;

    PhoneNumberDTO getPhoneNumberDTO(int phoneNumberId) throws BusinessException;
}
