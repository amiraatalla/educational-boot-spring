package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateLessonDTO;
import com.amira.educational.system.alemny.Dtos.CreateUnitDTO;
import com.amira.educational.system.alemny.Dtos.UpdateUnitDTO;
import com.amira.educational.system.alemny.Entities.Content;
import com.amira.educational.system.alemny.Entities.Lesson;
import com.amira.educational.system.alemny.Entities.Subject;
import com.amira.educational.system.alemny.Entities.Unit;
import com.amira.educational.system.alemny.Exceptions.NotFoundException;
import com.amira.educational.system.alemny.Repositories.ContentRepository;
import com.amira.educational.system.alemny.Repositories.SubjectRepository;
import com.amira.educational.system.alemny.Repositories.UnitRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnitServiceImpl implements UnitService {

    private final UnitRepository UnitRepository;
    private final SubjectRepository subjectRepository;
    private final ContentRepository contentRepository;
    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository UnitRepository, SubjectRepository subjectRepository, ContentRepository contentRepository, UnitRepository unitRepository) {
        this.UnitRepository = UnitRepository;
        this.subjectRepository = subjectRepository;
        this.contentRepository = contentRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> getAllUnits() {
        return UnitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Long id) {
        return UnitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Unit not found with id: " + id));

    }

    @Override
    public Unit saveUnit(CreateUnitDTO createUnitDTO) {
        Optional<Subject> subjectOpt = subjectRepository.findById(createUnitDTO.getSubjectId());

        if (!subjectOpt.isPresent()) {
            throw new IllegalArgumentException("Subject with ID " + createUnitDTO.getSubjectId() + " not found");
        }

        List<Lesson> lessons = createUnitDTO.getLessons().stream()
                .map(this::mapToLessonEntity)
                .collect(Collectors.toList());

        Unit unit = Unit.builder()
                .title(createUnitDTO.getTitle())
                .description(createUnitDTO.getDescription())
                .subjectId(subjectOpt.get())
                .lessons(lessons)
                .build();

        lessons.forEach(lesson -> lesson.setUnit(unit));
        return UnitRepository.save(unit);
    }

    private Lesson mapToLessonEntity(CreateLessonDTO lessonDTO) {
        List<Content> contents = contentRepository.findAllById(lessonDTO.getContentIds());

        return Lesson.builder()
                .title(lessonDTO.getTitle())
                .contents(contents)  // Set the retrieved Content entities
                .order(lessonDTO.getOrder())  // Assuming `getOrder()` is a valid method in CreateLessonDTO
                .build();
    }
     @Transactional
        public Unit updateUnit(Long id, UpdateUnitDTO updateUnitDTO) {
            // Retrieve the existing Unit
            Unit unit = UnitRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Unit with ID " + id + " not found"));

            // Retrieve and set the new subject if necessary
            Subject subject = subjectRepository.findById(updateUnitDTO.getSubjectId())
                    .orElseThrow(() -> new IllegalArgumentException("Subject with ID " + updateUnitDTO.getSubjectId() + " not found"));

            // Update the Unit fields
            unit.setTitle(updateUnitDTO.getTitle());
            unit.setDescription(updateUnitDTO.getDescription());
            unit.setSubjectId(subject);

            // Save and return the updated Unit
            return unitRepository.save(unit);
        }




    @Override
    public void deleteUnit(Long id) {
        UnitRepository.deleteById(id);
    }
}
