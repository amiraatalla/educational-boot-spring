package com.amira.educational.system.alemny.Dtos;


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
public class UpdateLessonDTO {

    private Long id;


    @Size(max = 100, message = "Title can be at most 100 characters")
    private String title;

    @Size(max = 255, message = "Description can be at most 255 characters")
    private String description;

    private Long unitId;

    private List<Long> contentIds;

    private Integer order;

}
