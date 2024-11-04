package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateLessonDTO;
import com.amira.educational.system.alemny.Entities.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons();
    Lesson getLessonById(Long id);
    Lesson saveLesson(CreateLessonDTO createLessonDTO);
    Lesson updateLesson(Long id, CreateLessonDTO createLessonDTO);
    void deleteLesson(Long id);
}
