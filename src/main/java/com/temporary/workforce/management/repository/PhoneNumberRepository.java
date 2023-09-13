package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository
        extends JpaRepository<PhoneNumber, Integer> {
}