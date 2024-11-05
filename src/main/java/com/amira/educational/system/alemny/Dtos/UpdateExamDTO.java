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
public class UpdateExamDTO {

    private Long id;

    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;


    @FutureOrPresent(message = "Exam date must be in the present or future")
    private LocalDateTime examDate;


    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;


    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "Invalid URL format")
    private String url;

    private Long subjectId;  // يمثل معرف المادة المرتبطة


}
