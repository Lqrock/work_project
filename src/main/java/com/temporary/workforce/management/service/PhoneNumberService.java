package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.PhoneNumberDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.PhoneNumber;
import com.temporary.workforce.management.repository.PhoneNumberRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneNumberService implements PhoneNumberServiceInterface {

    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(PhoneNumberService.class);

    @Override
    public void createPhoneNumber(PhoneNumberDTO phoneNumberDTO) {
        logger.info("Creating phone number");
        phoneNumberRepository.save(modelMapper.map(phoneNumberDTO, PhoneNumber.class));
    }

    @Override
    public PhoneNumberDTO updatePhoneNumber(PhoneNumberDTO phoneNumberDTO) throws EntityNotFoundException {
        logger.info("Updating phone number");
        Optional<PhoneNumber> existingPhoneNumberOpt = phoneNumberRepository.findById(phoneNumberDTO.getId());
        throwExceptionIfPhoneNumberNotFound(existingPhoneNumberOpt, phoneNumberDTO.getId());


        PhoneNumber existingPhoneNumber = modelMapper.map(phoneNumberDTO, PhoneNumber.class);
        phoneNumberRepository.save(existingPhoneNumber);
        return modelMapper.map(existingPhoneNumber, PhoneNumberDTO.class);
    }

    @Override
    public void deletePhoneNumber(int phoneNumberId) throws EntityNotFoundException {
        logger.info("Deleting phone number");
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        throwExceptionIfPhoneNumberNotFound(phoneNumber, phoneNumberId);
        phoneNumberRepository.deleteById(phoneNumberId);
        logger.info("Phone number deleted");
    }

    @Override
    public Optional<PhoneNumber> getPhoneNumber(int phoneNumberId) throws EntityNotFoundException {
        logger.info("Retrieving phone number");
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        throwExceptionIfPhoneNumberNotFound(phoneNumber, phoneNumberId);
        return phoneNumber;
    }

    @Override
    public PhoneNumberDTO getPhoneNumberDTO(int phoneNumberId) throws EntityNotFoundException {
        logger.info("Retrieving phone numberDTO");
        Optional<PhoneNumber> phoneNumber = phoneNumberRepository.findById(phoneNumberId);
        throwExceptionIfPhoneNumberNotFound(phoneNumber, phoneNumberId);
        return modelMapper.map(phoneNumber, PhoneNumberDTO.class);
    }

    private void throwExceptionIfPhoneNumberNotFound(Optional<PhoneNumber> phoneNumber, int phoneNumberId) throws EntityNotFoundException {
        if (phoneNumber.isEmpty()) {
            throw new EntityNotFoundException("Phone Number with ID " + phoneNumberId + " not found.");
        }
    }

}
