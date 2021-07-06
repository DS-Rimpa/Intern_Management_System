package com.intern.test.internmanagesys.service;


import com.intern.test.internmanagesys.entity.DesignationEntity;
import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.models.CreateDesignationRequest;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.repository.DesignationRepository;
import com.intern.test.internmanagesys.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
