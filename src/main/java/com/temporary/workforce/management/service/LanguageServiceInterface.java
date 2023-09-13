package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.LanguageDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Language;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LanguageServiceInterface {
    void createLanguage(LanguageDTO languageDTO);

    LanguageDTO updateLanguage(LanguageDTO languageDTO) throws BusinessException;

    void deleteLanguage(int languageId) throws BusinessException;

    LanguageDTO getLanguageDTO(int languageId) throws BusinessException;

    Optional<Language> getLanguage(int languageId) throws BusinessException;
}
