package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.TaskAllotmentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.security.auth.login.Configuration;
import java.util.List;

@Repository
public interface TaskAllotmentRepository extends JpaRepository<TaskAllotmentEntity, Long> {

    @Query("SELECT a from TaskAllotmentEntity a where a.taskStatus='PENDING'")
    List<TaskAllotmentEntity> findTaskAllotmentEntitiesByTaskStatusEquals(String string);


    @Query("SELECT a,b from TaskAllotmentEntity a join fetch a.internEntity b " +
            "where a.taskStatus='COMPLETE' order by b.name")
    List<TaskAllotmentEntity> findTaskAllotmentEntityByTaskStatus();

    @Modifying
    @Query(nativeQuery = true, value = "select i.name, avg(a.ranking) from task_allotment a join " +
            "intern i on i.id = a.intern_id group by i.name limit 10")
    List<TaskAllotmentEntity> findTaskAllotmentEntityByRankingIsGreaterThanEqual();


}
