package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
