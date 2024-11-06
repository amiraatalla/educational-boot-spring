package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateLessonDTO;
import com.amira.educational.system.alemny.Dtos.UpdateLessonDTO;
import com.amira.educational.system.alemny.Entities.Lesson;
import com.amira.educational.system.alemny.Entities.Unit;
import com.amira.educational.system.alemny.Repositories.LessonRepository;
import com.amira.educational.system.alemny.Repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final UnitRepository unitRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository, UnitRepository unitRepository) {
        this.lessonRepository = lessonRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found with id " + id));
    }

    @Override
    public Lesson saveLesson(CreateLessonDTO createLessonDTO) {
        Unit unit = unitRepository.findById(createLessonDTO.getUnitId())
                .orElseThrow(() -> new RuntimeException("Unit not found with id " + createLessonDTO.getUnitId()));

        Lesson lesson = Lesson.builder()
                .title(createLessonDTO.getTitle())
                .description(createLessonDTO.getDescription())
                .unit(unit)
                .order(createLessonDTO.getOrder())
                .build();

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson updateLesson(Long id, UpdateLessonDTO updateLessonDTO) {
        Lesson existingLesson = getLessonById(id);

        if (updateLessonDTO.getTitle() != null) {
            existingLesson.setTitle(updateLessonDTO.getTitle());
        }
        if (updateLessonDTO.getDescription() != null) {
            existingLesson.setDescription(updateLessonDTO.getDescription());
        }
        if (updateLessonDTO.getUnitId() != null) {
            Unit unit = unitRepository.findById(updateLessonDTO.getUnitId())
                    .orElseThrow(() -> new RuntimeException("Unit not found with id " + updateLessonDTO.getUnitId()));
            existingLesson.setUnit(unit);
        }
        if (updateLessonDTO.getOrder() != null) {
            existingLesson.setOrder(updateLessonDTO.getOrder());
        }

        return lessonRepository.save(existingLesson);
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Lesson not found with id " + id);
        }
        lessonRepository.deleteById(id);
    }
}
