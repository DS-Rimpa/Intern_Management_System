package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAllotmentRepository extends JpaRepository<TaskAllotmentEntity,Long> {
    @Query(value = "SELECT DISTINCT i.id,i.name from InternEntity i," +
            "TaskAllotmentEntity ta where i.id=ta.taskAllotId and ta.taskStatus='PENDING'")
    List<TaskAllotmentEntity> findAllByTaskStatus(String pending);



}
