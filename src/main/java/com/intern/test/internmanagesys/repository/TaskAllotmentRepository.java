package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAllotmentRepository extends JpaRepository<TaskAllotmentEntity,Long> {
}
