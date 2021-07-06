package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.entity.TaskEntity;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.CreateTaskRequest;
import com.intern.test.internmanagesys.service.ProjectService;
import com.intern.test.internmanagesys.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    private TaskService taskService;
    @PostMapping("/task")
    public ResponseEntity<String> saveTask(@Valid @RequestBody CreateTaskRequest createTaskRequest){
        taskService.addTasks(createTaskRequest);
        return ResponseEntity.ok("Successfully Created");

    }
    @GetMapping("/getAllTasks")
    public ResponseEntity<List<TaskEntity>> getAllInternTasks() {
        return ResponseEntity.ok(taskService.getAllInternTasks());
    }
}
