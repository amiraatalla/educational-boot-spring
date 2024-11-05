package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
