package com.amira.educational.system.alemny.Dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateExamDTO {

    private Long id;

    @NotNull(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotNull(message = "Exam date is required")
    @FutureOrPresent(message = "Exam date must be in the present or future")
    private LocalDateTime examDate;

    @NotNull(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @NotNull(message = "URL is required")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Invalid URL format")
    private String url;

    @NotNull(message = "Subject ID is required")
    private Long subjectId;  // يمثل معرف المادة المرتبطة


}
