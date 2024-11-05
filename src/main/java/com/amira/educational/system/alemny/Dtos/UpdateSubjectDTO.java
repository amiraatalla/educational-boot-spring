package com.amira.educational.system.alemny.Dtos;

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
public class UpdateSubjectDTO {

    private Long id;

    @Size(max = 100, message = "Name can be at most 100 characters")
    private String name;


    @Size(max = 255, message = "Description can be at most 255 characters")
    private String description;

    private String grade;


    private String session;

    @Size(max = 10, message = "Code can be at most 10 characters")
    private String code;

    private String type;

    private List<Long> unitIds;

    private List<Long> examIds;

}
