package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateExamDTO;
import com.amira.educational.system.alemny.Entities.Exam;

import java.util.List;

public interface ExamService {
    List<Exam> getAllExams();
    Exam getExamById(Long id);
    Exam saveExam(CreateExamDTO createExamDTO);
    Exam updateExam(Long id, CreateExamDTO createExamDTO);
    void deleteExam(Long id);
}
