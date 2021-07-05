package com.intern.test.internmanagesys.repository;

import com.intern.test.internmanagesys.entity.InternEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternRepository extends JpaRepository<InternEntity,Long> {
}
