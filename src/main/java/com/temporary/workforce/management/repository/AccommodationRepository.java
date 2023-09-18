package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Accommodation;
import com.temporary.workforce.management.model.OwnershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository
        extends JpaRepository<Accommodation, Integer> {
    Accommodation findByEmail(String email);
    List<Accommodation> findByOwnershipType(OwnershipType ownershipType);

}
