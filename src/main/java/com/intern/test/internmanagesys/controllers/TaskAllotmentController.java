package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import com.intern.test.internmanagesys.models.CreateProjectRequest;
import com.intern.test.internmanagesys.models.CreateTaskAllotmentRequest;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.models.TaskAllotUpdateRequest;
import com.intern.test.internmanagesys.service.ProjectService;
import com.intern.test.internmanagesys.service.TaskAllotmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intern/taskAllotment")
public class TaskAllotmentController {
    private TaskAllotmentService taskAllotmentService;

    public TaskAllotmentController(TaskAllotmentService taskAllotmentService) {
        this.taskAllotmentService = taskAllotmentService;
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveTaskAllotment(@Valid @RequestBody List<CreateTaskAllotmentRequest> createTaskAllotmentRequest)
    {
        taskAllotmentService.addTaskAllotments(createTaskAllotmentRequest);
        return ResponseEntity.ok("Successfully Created");

    }
    @GetMapping("/details")
    public ResponseEntity<List<TaskAllotmentEntity>> getAllTaskAllotments() {
        return ResponseEntity.ok(taskAllotmentService.getAllTaskDetails());
    }
    @GetMapping("/task/status")
    public ResponseEntity<List<TaskAllotmentEntity>> getAllPendingTasks() {
        return ResponseEntity.ok(taskAllotmentService.getIncompleteTasks());
    }



    @DeleteMapping("/delete/all")
    public String deleteAllTaskAllotments()
    {
        taskAllotmentService.deleteTaskAllotments();
        return "All tasks allotments deleted";
    }

    @PutMapping("/update/{taskAllotId}")
    public TaskAllotmentEntity changeTasks(@RequestBody TaskAllotUpdateRequest allotUpdateRequest, @PathVariable Long taskAllotId){

        return taskAllotmentService.updateTaskAllot(allotUpdateRequest,taskAllotId);
    }

}
