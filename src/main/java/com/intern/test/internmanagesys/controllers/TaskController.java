package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.TaskEntity;
import com.intern.test.internmanagesys.models.CreateTaskRequest;
import com.intern.test.internmanagesys.models.TaskUpdateRequest;
import com.intern.test.internmanagesys.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intern/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskEntity saveTask(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        return taskService.addTasks(createTaskRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskEntity> getAllInternTasks() {
        return taskService.getAllInternTasks();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInternsTasks() {
        taskService.deleteTasks();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskEntity changeTask(@RequestBody TaskUpdateRequest taskUpdateRequest, @PathVariable Long id) {

        return taskService.updateTask(taskUpdateRequest, id);
    }

}
