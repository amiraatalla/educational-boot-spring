package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.CreateLessonDTO;
import com.amira.educational.system.alemny.Dtos.UpdateLessonDTO;
import com.amira.educational.system.alemny.Entities.Lesson;
import com.amira.educational.system.alemny.Services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // GET /api/lessons - Get all lessons
    @GetMapping("/get-all")
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonService.getAllLessons();
        return ResponseEntity.ok(lessons);
    }

    // GET /api/lessons/{id} - Get lesson by ID
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Lesson lesson = lessonService.getLessonById(id);
        return ResponseEntity.ok(lesson);
    }

    // POST /api/lessons - Create a new lesson
    @PostMapping("/add-lesson")
    public ResponseEntity<Lesson> createLesson(@Validated @RequestBody CreateLessonDTO createLessonDTO) {
        Lesson lesson = lessonService.saveLesson(createLessonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(lesson);
    }

    // PUT /api/lessons/{id} - Update an existing lesson
    @PutMapping("/update-lesson/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @Validated @RequestBody UpdateLessonDTO updateLessonDTO) {
        Lesson updatedLesson = lessonService.updateLesson(id, updateLessonDTO);
        return ResponseEntity.ok(updatedLesson);
    }

    // DELETE /api/lessons/{id} - Delete a lesson
    @DeleteMapping("/delete-lesson/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
