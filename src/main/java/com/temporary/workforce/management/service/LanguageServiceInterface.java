package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.LanguageDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Language;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LanguageServiceInterface {
    void createLanguage(LanguageDTO languageDTO);

    LanguageDTO updateLanguage(LanguageDTO languageDTO) throws EntityNotFoundException;

    void deleteLanguage(int languageId) throws EntityNotFoundException;

    LanguageDTO getLanguageDTO(int languageId) throws EntityNotFoundException;

    Optional<Language> getLanguage(int languageId) throws EntityNotFoundException;
}
