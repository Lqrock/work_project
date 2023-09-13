package com.temporary.workforce.management.repository;

import com.temporary.workforce.management.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository
        extends JpaRepository<Project, Integer> {
}
