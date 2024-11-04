package com.amira.educational.system.alemny.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class CreateContentDTO {

        private Long id;

        @NotBlank(message = "Content type is required")
        @Size(max = 50, message = "Content type can be at most 50 characters")
        private String type;  // Content type (e.g., video, file)

        @NotBlank(message = "URL is required")
        @Size(max = 255, message = "URL can be at most 255 characters")
        private String url;  // Content URL (e.g., link to video or file)

        @NotNull(message = "Lesson ID is required")
        private Long lessonId;  // ID of the associated lesson


    }

