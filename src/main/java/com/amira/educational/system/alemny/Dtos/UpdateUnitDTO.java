package com.amira.educational.system.alemny.Dtos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UpdateUnitDTO {

    private Long id;
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @Size(min = 1, max = 1000, message = "Description must be between 1 and 1000 characters")
    private String description;

    private Long subjectId;  // معرف المادة المرتبطة

    private List<CreateLessonDTO> lessons;  // قائمة الدروس المرتبطة بالوحدة




}
