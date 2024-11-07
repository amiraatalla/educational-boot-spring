package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.CreateContentDTO;
import com.amira.educational.system.alemny.Dtos.UpdateContentDTO;
import com.amira.educational.system.alemny.Entities.Content;
import com.amira.educational.system.alemny.Services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    // GET /api/contents - Get all contents
    @GetMapping("/get-all")
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.getAllContents();
        return ResponseEntity.ok(contents);
    }

    // GET /api/contents/{id} - Get content by ID
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        Content content = contentService.getContentById(id);
        return ResponseEntity.ok(content);
    }

    // POST /api/contents - Create a new content
    @PostMapping("/add-content")
    public ResponseEntity<Content> createContent(@Validated @RequestBody CreateContentDTO createContentDTO) {
        Content content = contentService.saveContent(createContentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(content);
    }

    // PUT /api/contents/{id} - Update an existing content
    @PutMapping("/update-content/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @Validated @RequestBody UpdateContentDTO updateContentDTO) {
        Content updatedContent = contentService.updateContent(id, updateContentDTO);
        return ResponseEntity.ok(updatedContent);
    }

    // DELETE /api/contents/{id} - Delete an content
    @DeleteMapping("/delete-content/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}
