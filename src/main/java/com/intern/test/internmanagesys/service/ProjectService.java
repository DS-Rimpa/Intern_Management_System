package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.InternDesignationUpdate;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import com.intern.test.internmanagesys.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProjects(CreateProjectRequest createProjectRequest) {
        ProjectEntity projectEntity=new ProjectEntity();
        projectEntity.setProjectName(createProjectRequest.getProjectName());
        projectRepository.save(projectEntity);
    }

    public List<ProjectEntity> getAllProjects()
    {
        return projectRepository.findAll();
    }

    public String deleteProjects(){
        projectRepository.deleteAll();
        return "All designations deleted";
    }
    public ProjectEntity updateProject(ProjectUpdateRequest projectRequest, Long projectId) {

        Optional<ProjectEntity> byId = projectRepository.findById(projectId);
        ProjectEntity projectEntity = byId.get();
        projectEntity.setProjectName(projectRequest.getProjectName());
        return projectRepository.save(projectEntity);
    }
}
