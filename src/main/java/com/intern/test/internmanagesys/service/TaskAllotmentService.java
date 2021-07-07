package com.intern.test.internmanagesys.service;

import com.intern.test.internmanagesys.entity.InternEntity;
import com.intern.test.internmanagesys.entity.ProjectEntity;
import com.intern.test.internmanagesys.entity.StatusType;
import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import com.intern.test.internmanagesys.models.CreateInternRequest;
import com.intern.test.internmanagesys.models.CreateTaskAllotmentRequest;
import com.intern.test.internmanagesys.models.ProjectUpdateRequest;
import com.intern.test.internmanagesys.models.TaskAllotUpdateRequest;
import com.intern.test.internmanagesys.repository.InternRepository;
import com.intern.test.internmanagesys.repository.TaskAllotmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskAllotmentService {
    private final TaskAllotmentRepository taskAllotmentRepository;

    @Autowired
    public TaskAllotmentService(TaskAllotmentRepository taskAllotmentRepository) {
        this.taskAllotmentRepository = taskAllotmentRepository;
    }
    public List<TaskAllotmentEntity> addTaskAllotments(List<CreateTaskAllotmentRequest> requests) {

        List<TaskAllotmentEntity> collect = requests.stream().map(request -> TaskAllotmentEntity
                .builder()
                .feedback(request.getFeedback())
                .ranking(request.getRanking())
                .taskStatus(request.getTaskStatus())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build()).collect(Collectors.toList());
        return taskAllotmentRepository.saveAll(collect);

    }
    public List<TaskAllotmentEntity> getAllTaskDetails()
    {
        return taskAllotmentRepository.findAll();
    }

    public List<TaskAllotmentEntity> getIncompleteTasks(){
        return taskAllotmentRepository.findAllByTaskStatus("PENDING");
    }


    public String deleteTaskAllotments(){
        taskAllotmentRepository.deleteAll();
        return "All task allotments are deleted";
    }
    public TaskAllotmentEntity updateTaskAllot(TaskAllotUpdateRequest taskRequest, Long taskAllotId) {

        Optional<TaskAllotmentEntity> byId = taskAllotmentRepository.findById(taskAllotId);
        TaskAllotmentEntity taskAllotmentEntity = byId.get();
        taskAllotmentEntity.setFeedback(taskRequest.getFeedback());
        taskAllotmentEntity.setRanking(taskRequest.getRanking());
        taskAllotmentEntity.setEndDate(taskRequest.getEndDate());
        taskAllotmentEntity.setTaskStatus(taskRequest.getTaskStatus());
        return taskAllotmentRepository.save(taskAllotmentEntity);
    }

}
