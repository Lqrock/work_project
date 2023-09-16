package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmailDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Email;
import com.temporary.workforce.management.repository.EmailRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService implements EmailServiceInterface{

    @Autowired
    EmailRepository emailRepository;

    ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Override
    public void createEmail(EmailDTO emailDTO) {
        logger.info("Creating email");
        emailRepository.save(modelMapper.map(emailDTO, Email.class));
    }

    @Override
    public EmailDTO updateEmail(EmailDTO emailDTO) throws EntityNotFoundException {
        logger.info("Updating email");
        Optional<Email> existingEmailOpt = emailRepository.findById(emailDTO.getId());
        throwExceptionIfEmailNotFound(existingEmailOpt, emailDTO.getId());
        Email existingEmail = modelMapper.map(emailDTO, Email.class);
        emailRepository.save(existingEmail);
        return modelMapper.map(existingEmail, EmailDTO.class);

    }

    @Override
    public void deleteEmail(int emailId) throws EntityNotFoundException {
        logger.info("Deleting email");
        Optional<Email> email = emailRepository.findById(emailId);
        throwExceptionIfEmailNotFound(email, emailId);
        emailRepository.deleteById(emailId);
    }

    @Override
    public EmailDTO getEmailDTO(int emailId) throws EntityNotFoundException {
        logger.info("Retrieving email");
        Optional<Email> emailOpt = emailRepository.findById(emailId);
        throwExceptionIfEmailNotFound(emailOpt, emailId);
        Email email = emailOpt.get();
        return modelMapper.map(email, EmailDTO.class);
    }

    @Override
    public Optional<Email> getEmail(int emailId) throws EntityNotFoundException {
        logger.info("Retrieving email");
        Optional<Email> email = emailRepository.findById(emailId);
        throwExceptionIfEmailNotFound(email, emailId);
        return email;
    }

    private void throwExceptionIfEmailNotFound(Optional<Email> email, int emailId) throws EntityNotFoundException {
        if(email.isEmpty()){
            throw new EntityNotFoundException("Email with ID " + emailId + " not found!");
        }
    }

}
