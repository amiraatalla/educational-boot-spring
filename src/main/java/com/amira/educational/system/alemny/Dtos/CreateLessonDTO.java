package com.amira.educational.system.alemny.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateLessonDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title can be at most 100 characters")
    private String title;

    @Size(max = 255, message = "Description can be at most 255 characters")
    private String description;

    @NotNull(message = "Unit ID is required")
    private Long unitId;

    private List<Long> contentIds;

}
