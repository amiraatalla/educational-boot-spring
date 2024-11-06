package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.CreateSubjectDTO;
import com.amira.educational.system.alemny.Dtos.UpdateSubjectDTO;
import com.amira.educational.system.alemny.Entities.Subject;
import com.amira.educational.system.alemny.Services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // GET /api/subjects - Get all subjects
    @GetMapping("/get-all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    // GET /api/subjects/{id} - Get subject by ID
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Subject subject = subjectService.getSubjectById(id);
        return ResponseEntity.ok(subject);
    }

    // POST /api/subjects - Create a new subject
    @PostMapping("/add-subject")
    public ResponseEntity<Subject> createSubject(@Validated @RequestBody CreateSubjectDTO createSubjectDTO) {
        Subject subject = subjectService.saveSubject(createSubjectDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(subject);
    }

    // PUT /api/subjects/{id} - Update an existing subject
    @PutMapping("/update-subject/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @Validated @RequestBody UpdateSubjectDTO updateSubjectDTO) {
        Subject updatedSubject = subjectService.updateSubject(id, updateSubjectDTO);
        return ResponseEntity.ok(updatedSubject);
    }

    // DELETE /api/subjects/{id} - Delete a subject
    @DeleteMapping("/delete-subject/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
