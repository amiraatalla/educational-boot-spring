package com.amira.educational.system.alemny.Repositories;

import com.amira.educational.system.alemny.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<Student, Long> {
}
