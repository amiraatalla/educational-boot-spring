package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateContentDTO;
import com.amira.educational.system.alemny.Dtos.UpdateContentDTO;
import com.amira.educational.system.alemny.Entities.Content;
import com.amira.educational.system.alemny.Entities.Lesson;
import com.amira.educational.system.alemny.Repositories.ContentRepository;
import com.amira.educational.system.alemny.Repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;
    private final LessonRepository lessonRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository, LessonRepository lessonRepository) {
        this.contentRepository = contentRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Content getContentById(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Content not found with id " + id));
    }

    @Override
    public Content saveContent(CreateContentDTO createContentDTO) {
        Lesson lesson = lessonRepository.findById(createContentDTO.getLessonId())
                .orElseThrow(() -> new RuntimeException("Lesson not found with id " + createContentDTO.getLessonId()));

        Content content = Content.builder()
                .type(createContentDTO.getType())
                .url(createContentDTO.getUrl())
                .lesson(lesson)
                .build();

        return contentRepository.save(content);
    }

    @Override
    public Content updateContent(Long id, UpdateContentDTO updateContentDTO) {
        Content existingContent = getContentById(id);

        if (updateContentDTO.getType() != null) {
            existingContent.setType(updateContentDTO.getType());
        }
        if (updateContentDTO.getUrl() != null) {
            existingContent.setUrl(updateContentDTO.getUrl());
        }
        if (updateContentDTO.getLessonId() != null) {
            Lesson lesson = lessonRepository.findById(updateContentDTO.getLessonId())
                    .orElseThrow(() -> new RuntimeException("Lesson not found with id " + updateContentDTO.getLessonId()));
            existingContent.setLesson(lesson);
        }

        return contentRepository.save(existingContent);
    }

    @Override
    public void deleteContent(Long id) {
        if (!contentRepository.existsById(id)) {
            throw new RuntimeException("Content not found with id " + id);
        }
        contentRepository.deleteById(id);
    }
}
