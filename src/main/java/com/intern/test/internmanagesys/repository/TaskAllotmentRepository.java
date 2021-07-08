package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAllotmentRepository extends JpaRepository<TaskAllotmentEntity,Long> {

    @Query(value = "SELECT DISTINCT i.id,i.name from InternEntity i where i.id in (SELECT i.id from " +
            "TaskAllotmentEntity where taskStatus='PENDING')")
    List<TaskAllotmentEntity> findAll();



//    @Query(value = "SELECT DISTINCT i.id,i.name from InternEntity i where i.id in (SELECT i.id from " +
//            "TaskAllotmentEntity t where t.taskStatus='COMPLETE') order by i.id ASC fetch first 10 rows only")
//    List<TaskAllotmentEntity> findAll();





}
