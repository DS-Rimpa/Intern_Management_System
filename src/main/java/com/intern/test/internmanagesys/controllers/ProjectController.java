package com.intern.test.internmanagesys.controllers;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.service.DesignationService;
import com.intern.test.internmanagesys.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    private ProjectService projectService;


    @PostMapping("/project")
    public ResponseEntity<String> saveProject(@Valid @RequestBody CreateProjectRequest createProjectRequest){
        projectService.addProjects(createProjectRequest);
        return ResponseEntity.ok("Successfully Created");

    }
    @GetMapping("/getAllProjects")
    public ResponseEntity<List<ProjectEntity>> getAllInternsProject() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
