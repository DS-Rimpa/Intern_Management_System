package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.DesignationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity,Long> {
}
