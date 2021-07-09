package com.intern.test.internmanagesys.controllers;


import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intern/project")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public ProjectEntity saveProject(@Valid @RequestBody CreateProjectRequest createProjectRequest){
        return projectService.addProjects(createProjectRequest);

    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectEntity> getAllInternsProject() {
        return projectService.getAllProjects();
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProjectEntity changeProject(@RequestBody ProjectUpdateRequest projectUpdateRequest, @PathVariable Long id){

        return projectService.updateProject(projectUpdateRequest, id);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInternsDesignation()
    {
       projectService.deleteProjects();
    }
}
