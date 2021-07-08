package com.intern.test.internmanagesys.controllers;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.InternUpdateRequest;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.service.DesignationService;
import com.intern.test.internmanagesys.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intern/project")
public class ProjectController {
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    private ProjectService projectService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)

    public ProjectEntity saveProject(@Valid @RequestBody CreateProjectRequest createProjectRequest){
        return projectService.addProjects(createProjectRequest);

    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectEntity> getAllInternsProject() {
        return projectService.getAllProjects();
    }
    @PutMapping("/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectEntity changeProject(@RequestBody ProjectUpdateRequest projectUpdateRequest, @PathVariable Long projectId){

        return projectService.updateProject(projectUpdateRequest,projectId);
    }
    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ProjectEntity deleteInternsDesignation()
    {
       return projectService.deleteProjects();
    }
}
