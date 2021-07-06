package com.intern.test.internmanagesys.service;

import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.entity.TaskEntity;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.CreateTaskRequest;
import com.intern.test.internmanagesys.repository.ProjectRepository;
import com.intern.test.internmanagesys.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTasks(CreateTaskRequest createTaskRequest) {
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setTaskDescription(createTaskRequest.getTaskDescription());
        taskRepository.save(taskEntity);
    }

    public List<TaskEntity> getAllInternTasks()
    {
        return taskRepository.findAll();
    }


}
