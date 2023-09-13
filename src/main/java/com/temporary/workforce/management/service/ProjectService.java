package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Email;
import com.temporary.workforce.management.model.Project;
import com.temporary.workforce.management.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    ProjectRepository projectRepository;

    Logger logger = LoggerFactory.getLogger(ProjectService.class);

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public void createProject(ProjectDTO projectDTO) {
        logger.info("Creating project {}", projectDTO.getId());
        Project project = modelMapper.map(projectDTO, Project.class);
        if(project.getEmails() != null){
            List<Email> emails = project.getEmails();
            emails.forEach(email -> email.setProject(project));
            project.setEmails(emails);
        }

        projectRepository.save(project);
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) throws BusinessException {
        logger.info("Updating project");
        Optional<Project> existingProjectOpt = projectRepository.findById(projectDTO.getId());
        throwExceptionIfProjectNotFound(existingProjectOpt, projectDTO.getId());
        Project existingProject = modelMapper.map(projectDTO, Project.class);
        if (existingProjectOpt.isPresent() && existingProjectOpt.get().getEmployee() != null){
            existingProject.setEmployee(existingProjectOpt.get().getEmployee());
        }
        if (existingProjectOpt.isPresent() && !existingProjectOpt.get().getJobPositions().isEmpty()) {
            existingProject.setJobPositions(existingProjectOpt.get().getJobPositions());
        }
        if (existingProject.getEmails() != null) {
            existingProject.getEmails().forEach(email -> email.setProject(existingProject));
        }
        if (existingProject.getPhoneNumbers() != null) {
            existingProject.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setProject(existingProject));
        }

        projectRepository.save(existingProject);
        return modelMapper.map(existingProject, ProjectDTO.class);
    }

    @Override
    public void deleteProject(int projectId) throws BusinessException {
        logger.info("Deleting project");
        Optional<Project> project = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(project, projectId);
        projectRepository.deleteById(projectId);
        logger.info("Project deleted successfully");
    }

    @Override
    public ProjectDTO getProjectDTO(int projectId) throws BusinessException {
        logger.info("Retrieving projectDTO");
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(projectOpt, projectId);
        return modelMapper.map(projectOpt, ProjectDTO.class);
    }

    @Override
    public Optional<Project> getProject(int projectId) throws BusinessException {
        logger.info("Retrieving project");
        Optional<Project> project = projectRepository.findById(projectId);
        throwExceptionIfProjectNotFound(project, projectId);
        return project;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        if (projects != null && !projects.isEmpty()) {
            projects.forEach(project -> projectDTOList.add(modelMapper.map(project, ProjectDTO.class)));
        }
        return projectDTOList;
    }

    void throwExceptionIfProjectNotFound(Optional<Project> project, int projectId) throws BusinessException {
        if (project.isEmpty()) {
            throw new BusinessException("Project with id " + projectId + " not found");
        }
    }


}
