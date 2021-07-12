package com.intern.test.internmanagesys.controllers;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import com.intern.test.internmanagesys.models.CreateTaskAllotmentRequest;
import com.intern.test.internmanagesys.models.TaskAllotUpdateRequest;
import com.intern.test.internmanagesys.service.TaskAllotmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/intern/taskAllotment")
public class TaskAllotmentController {

    //private InternRepository internRepository;
    private TaskAllotmentService taskAllotmentService;

    public TaskAllotmentController(TaskAllotmentService taskAllotmentService) {
        this.taskAllotmentService = taskAllotmentService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<TaskAllotmentEntity> saveTaskAllotment(@Valid @RequestBody List<CreateTaskAllotmentRequest> createTaskAllotmentRequest) {
        return taskAllotmentService.addTaskAllotments(createTaskAllotmentRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotmentEntity> getAllTaskAllotments() {
        return taskAllotmentService.getTaskDetails();
    }

    @GetMapping("/pending")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotmentEntity> getAllTaskStatus() {
        return taskAllotmentService.getPendingTasks();
    }


    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotmentEntity> getIntern() {
        return taskAllotmentService.getTaskStatus();
    }

    @GetMapping("/ranking")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskAllotmentEntity> getRanking() {
        return taskAllotmentService.getAvgRanking();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllTaskAllotments() {
        taskAllotmentService.deleteTaskAllotments();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskAllotmentEntity changeTasks(@RequestBody TaskAllotUpdateRequest allotUpdateRequest, @PathVariable Long id) {

        return taskAllotmentService.updateTaskAllot(allotUpdateRequest, id);
    }

}
