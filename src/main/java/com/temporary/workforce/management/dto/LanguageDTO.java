package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.LanguageEnum;
import lombok.Data;

@Data
public class LanguageDTO {

    private int id;

    private LanguageEnum spokenLanguage;
}
