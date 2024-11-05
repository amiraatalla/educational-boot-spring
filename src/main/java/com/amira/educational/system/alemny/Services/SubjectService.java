package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateSubjectDTO;
import com.amira.educational.system.alemny.Dtos.UpdateSubjectDTO;
import com.amira.educational.system.alemny.Entities.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(Long id);
    Subject saveSubject(CreateSubjectDTO createSubjectDTO);
    Subject updateSubject(Long id, UpdateSubjectDTO updateSubjectDTO);
    void deleteSubject(Long id);
}
