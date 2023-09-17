package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.ProjectDTO;
import com.temporary.workforce.management.exception.EntityNotFoundException;
import com.temporary.workforce.management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDto) {
        projectService.createProject(projectDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO) throws EntityNotFoundException {
        projectService.updateProject(projectDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<ProjectDTO> deleteProject(@PathVariable int projectId) throws EntityNotFoundException {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get/{projectId}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable int projectId) throws EntityNotFoundException {
        return new ResponseEntity<>(projectService.getProjectDTO(projectId), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/get-all")
    public ResponseEntity<List<ProjectDTO>> showAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }



}
