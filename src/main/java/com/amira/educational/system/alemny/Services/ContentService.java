package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateContentDTO;
import com.amira.educational.system.alemny.Dtos.UpdateContentDTO;
import com.amira.educational.system.alemny.Entities.Content;

import java.util.List;

public interface ContentService {
    List<Content> getAllContents();
    Content getContentById(Long id);
    Content saveContent(CreateContentDTO createContentDTO);
    Content updateContent(Long id, UpdateContentDTO updateContentDTO);
    void deleteContent(Long id);
}
