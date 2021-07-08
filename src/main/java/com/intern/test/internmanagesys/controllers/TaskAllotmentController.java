package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import com.intern.test.internmanagesys.models.CreateTaskAllotmentRequest;
import com.intern.test.internmanagesys.models.TaskAllotUpdateRequest;
import com.intern.test.internmanagesys.service.TaskAllotmentService;
import org.springframework.http.HttpStatus;
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


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public List<TaskAllotmentEntity> saveTaskAllotment(@Valid @RequestBody List<CreateTaskAllotmentRequest> createTaskAllotmentRequest)
    {
        return taskAllotmentService.addTaskAllotments(createTaskAllotmentRequest);

    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotmentEntity> getAllTaskAllotments() {
        return taskAllotmentService.getAllTaskDetails();
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TaskAllotmentEntity deleteAllTaskAllotments()
    {
        taskAllotmentService.deleteTaskAllotments();
        return null;
    }

    @PutMapping("/{taskAllotId}")
    @ResponseStatus(HttpStatus.OK)
    public TaskAllotmentEntity changeTasks(@RequestBody TaskAllotUpdateRequest allotUpdateRequest, @PathVariable Long taskAllotId){

        return taskAllotmentService.updateTaskAllot(allotUpdateRequest,taskAllotId);
    }

}
