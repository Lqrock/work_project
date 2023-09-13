package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectServiceInterface {

    void createProject(ProjectDTO projectDTO);

    ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException;

    void deleteProject(int projectId) throws BusinessException;

    ProjectDTO getProjectDTO(int projectId) throws BusinessException;

    Optional<Project> getProject(int projectId) throws BusinessException;

    List<ProjectDTO> getAllProjects();

}
