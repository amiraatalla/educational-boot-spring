package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Entities.Student;
import com.amira.educational.system.alemny.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/api/students")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("/get-all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-by-id/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PatchMapping("/update-student/{id}")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("/delete-studend/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
