package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository
        extends JpaRepository<Language, Integer> {
}
