package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.LanguageDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Language;
import com.temporary.workforce.management.repository.LanguageRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageService implements LanguageServiceInterface{

    @Autowired
    LanguageRepository languageRepository;

    Logger logger = LoggerFactory.getLogger(LanguageService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createLanguage(LanguageDTO languageDTO) {
        logger.info("Creating language");
        languageRepository.save(modelMapper.map(languageDTO, Language.class));
    }

    @Override
    public LanguageDTO updateLanguage(LanguageDTO languageDTO) throws BusinessException {
        logger.info("Updating language");
        Optional<Language> existingLanguageOpt = languageRepository.findById(languageDTO.getId());
        throwExceptionIfLanguageNotFound(existingLanguageOpt, languageDTO.getId());
        Language existingLanguage = modelMapper.map(languageDTO, Language.class);
        if (existingLanguageOpt.get().getEmployee() != null) {
            existingLanguage.setEmployee(existingLanguageOpt.get().getEmployee());
        }
        languageRepository.save(existingLanguage);
        return modelMapper.map(existingLanguage, LanguageDTO.class);
    }

    @Override
    public void deleteLanguage(int languageId) throws BusinessException {
        logger.info("Deleting language");
        Optional<Language> language = languageRepository.findById(languageId);
        throwExceptionIfLanguageNotFound(language, languageId);
        languageRepository.deleteById(languageId);
    }

    @Override
    public LanguageDTO getLanguageDTO(int languageId) throws BusinessException {
        logger.info("Retrieving language");
        Optional<Language> language = languageRepository.findById(languageId);
        throwExceptionIfLanguageNotFound(language, languageId);
        System.out.println(modelMapper.map(language, LanguageDTO.class));
        return modelMapper.map(language, LanguageDTO.class);
    }

    @Override
    public Optional<Language> getLanguage(int languageId) throws BusinessException {
        logger.info("Retrieving language");
        Optional<Language> language = languageRepository.findById(languageId);
        throwExceptionIfLanguageNotFound(language, languageId);
        return language;
    }

    private void throwExceptionIfLanguageNotFound(Optional<Language> language, int languageId) throws BusinessException{
        if(language.isEmpty()){
            throw new BusinessException("Language with ID " + languageId + " not found");
        }
    }

}
