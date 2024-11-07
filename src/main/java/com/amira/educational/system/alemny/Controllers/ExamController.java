package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.CreateExamDTO;
import com.amira.educational.system.alemny.Dtos.UpdateExamDTO;
import com.amira.educational.system.alemny.Entities.Exam;
import com.amira.educational.system.alemny.Services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // GET /api/exams - Get all exams
    @GetMapping("/get-all")
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return ResponseEntity.ok(exams);
    }

    // GET /api/exams/{id} - Get exam by ID
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return ResponseEntity.ok(exam);
    }

    // POST /api/exams - Create a new exam
    @PostMapping("/add-exam")
    public ResponseEntity<Exam> createExam(@Validated @RequestBody CreateExamDTO createExamDTO) {
        Exam exam = examService.saveExam(createExamDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exam);
    }

    // PUT /api/exams/{id} - Update an existing exam
    @PutMapping("/update-exam/{id}")
    public ResponseEntity<Exam> updateExam(@PathVariable Long id, @Validated @RequestBody UpdateExamDTO updateExamDTO) {
        Exam updatedExam = examService.updateExam(id, updateExamDTO);
        return ResponseEntity.ok(updatedExam);
    }

    // DELETE /api/exams/{id} - Delete an exam
    @DeleteMapping("/delete-exam/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}
