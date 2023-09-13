package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository
        extends JpaRepository<Email, Integer> {
}
