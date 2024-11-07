package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateExamDTO;
import com.amira.educational.system.alemny.Dtos.UpdateExamDTO;
import com.amira.educational.system.alemny.Entities.Exam;
import com.amira.educational.system.alemny.Entities.Subject;
import com.amira.educational.system.alemny.Repositories.ExamRepository;
import com.amira.educational.system.alemny.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository, SubjectRepository subjectRepository) {
        this.examRepository = examRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found with id " + id));
    }

    @Override
    public Exam saveExam(CreateExamDTO createExamDTO) {
        Subject subject = subjectRepository.findById(createExamDTO.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + createExamDTO.getSubjectId()));

        Exam exam = Exam.builder()
                .title(createExamDTO.getTitle())
                .examDate(createExamDTO.getExamDate())
                .description(createExamDTO.getDescription())
                .url(createExamDTO.getUrl())
                .subject(subject)
                .build();

        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Long id, UpdateExamDTO updateExamDTO) {
        Exam existingExam = getExamById(id);

        if (updateExamDTO.getTitle() != null) {
            existingExam.setTitle(updateExamDTO.getTitle());
        }
        if (updateExamDTO.getExamDate() != null) {
            existingExam.setExamDate(updateExamDTO.getExamDate());
        }
        if (updateExamDTO.getDescription() != null) {
            existingExam.setDescription(updateExamDTO.getDescription());
        }
        if (updateExamDTO.getUrl() != null) {
            existingExam.setUrl(updateExamDTO.getUrl());
        }
        if (updateExamDTO.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(updateExamDTO.getSubjectId())
                    .orElseThrow(() -> new RuntimeException("Subject not found with id " + updateExamDTO.getSubjectId()));
            existingExam.setSubject(subject);
        }

        return examRepository.save(existingExam);
    }

    @Override
    public void deleteExam(Long id) {
        if (!examRepository.existsById(id)) {
            throw new RuntimeException("Exam not found with id " + id);
        }
        examRepository.deleteById(id);
    }
}
