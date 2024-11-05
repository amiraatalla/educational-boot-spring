package com.amira.educational.system.alemny.Dtos;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class UpdateContentDTO {

        private Long id;

        @Size(max = 50, message = "Content type can be at most 50 characters")
        private String type;  // Content type (e.g., video, file)

        @Size(max = 255, message = "URL can be at most 255 characters")
        private String url;  // Content URL (e.g., link to video or file)

        private Long lessonId;  // ID of the associated lesson


    }

