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
public class CreateSubjectDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name can be at most 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description can be at most 255 characters")
    private String description;

    @NotBlank(message = "Grade is required")
    private String grade;

    @NotBlank(message = "Session is required")
    private String session;

    @NotBlank(message = "Code is required")
    @Size(max = 10, message = "Code can be at most 10 characters")
    private String code;

    private String type;

    @NotNull(message = "Unit IDs cannot be null")
    private List<Long> unitIds;

    @NotNull(message = "Exam IDs cannot be null")
    private List<Long> examIds;

}
