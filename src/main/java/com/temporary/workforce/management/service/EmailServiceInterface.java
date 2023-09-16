package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmailDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Email;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmailServiceInterface {

    void createEmail(EmailDTO emailDTO);

    EmailDTO updateEmail(EmailDTO emailDTO) throws EntityNotFoundException;

    void deleteEmail(int emailId) throws EntityNotFoundException;

    EmailDTO getEmailDTO(int emailId) throws EntityNotFoundException;

    Optional<Email> getEmail(int emailId) throws EntityNotFoundException;
}
