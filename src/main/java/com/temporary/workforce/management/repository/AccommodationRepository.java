package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository
        extends JpaRepository<Accommodation, Integer> {
    Accommodation findByEmail(String email);
}
