package com.intern.test.internmanagesys.service;

import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.entity.TaskEntity;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.CreateTaskRequest;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.models.TaskUpdateRequest;
import com.intern.test.internmanagesys.repository.ProjectRepository;
import com.intern.test.internmanagesys.repository.TaskRepository;
import com.sun.jdi.request.InvalidRequestStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity addTasks(CreateTaskRequest createTaskRequest) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskDescription(createTaskRequest.getTaskDescription());
        return taskRepository.save(taskEntity);
    }

    public List<TaskEntity> getAllInternTasks() {
        return taskRepository.findAll();
    }

    public void deleteTasks() {
        taskRepository.deleteAll();
    }

    public TaskEntity updateTask(TaskUpdateRequest taskUpdateRequest, Long id) {

        Optional<TaskEntity> byId = taskRepository.findById(id);
        if (!byId.isPresent()) throw new InvalidRequestStateException
                (String.format("Intern with the provided id does not exist%s", id));
        TaskEntity taskEntity = byId.get();
        taskEntity.setTaskDescription(taskUpdateRequest.getTaskDescription());
        return taskRepository.save(taskEntity);
    }


}
