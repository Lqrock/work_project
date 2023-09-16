package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectServiceInterface {

    void createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO) throws EntityNotFoundException;

    void deleteProject(int projectId) throws EntityNotFoundException;

    ProjectDTO getProjectDTO(int projectId) throws EntityNotFoundException;

    Optional<Project> getProject(int projectId) throws EntityNotFoundException;

    List<ProjectDTO> getAllProjects();

}
