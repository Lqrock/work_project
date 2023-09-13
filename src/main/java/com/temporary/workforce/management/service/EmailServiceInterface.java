package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmailDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Email;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmailServiceInterface {

    void createEmail(EmailDTO emailDTO);

    EmailDTO updateEmail(EmailDTO emailDTO) throws BusinessException;

    void deleteEmail(int emailId) throws BusinessException;

    EmailDTO getEmailDTO(int emailId) throws BusinessException;

    Optional<Email> getEmail(int emailId) throws BusinessException;
}
