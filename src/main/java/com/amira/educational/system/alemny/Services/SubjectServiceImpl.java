package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateSubjectDTO;
import com.amira.educational.system.alemny.Dtos.UpdateSubjectDTO;
import com.amira.educational.system.alemny.Entities.Subject;
import com.amira.educational.system.alemny.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + id));
    }

    @Override
    public Subject saveSubject(CreateSubjectDTO createSubjectDTO) {
        Subject subject = Subject.builder()
                .name(createSubjectDTO.getName())
                .description(createSubjectDTO.getDescription())
                .grade(createSubjectDTO.getGrade())
                .session(createSubjectDTO.getSession())
                .code(createSubjectDTO.getCode())
                .type(createSubjectDTO.getType())
                .build();

        return subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(Long id, UpdateSubjectDTO updateSubjectDTO) {
        Subject existingSubject = getSubjectById(id);

        if (updateSubjectDTO.getName() != null) {
            existingSubject.setName(updateSubjectDTO.getName());
        }
        if (updateSubjectDTO.getDescription() != null) {
            existingSubject.setDescription(updateSubjectDTO.getDescription());
        }
        if (updateSubjectDTO.getGrade() != null) {
            existingSubject.setGrade(updateSubjectDTO.getGrade());
        }
        if (updateSubjectDTO.getSession() != null) {
            existingSubject.setSession(updateSubjectDTO.getSession());
        }
        if (updateSubjectDTO.getCode() != null) {
            existingSubject.setCode(updateSubjectDTO.getCode());
        }
        if (updateSubjectDTO.getType() != null) {
            existingSubject.setType(updateSubjectDTO.getType());
        }

        return subjectRepository.save(existingSubject);
    }

    @Override
    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new RuntimeException("Subject not found with id " + id);
        }
        subjectRepository.deleteById(id);
    }
}
