package com.example.lmssystem.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {

    @NotEmpty(message = "Course ID cannot be empty")
    private String courseId;

    @NotEmpty(message = "Category ID cannot be empty")
    private String category;

    private Teacher teacher;

    @NotEmpty(message = "Description ID cannot be empty")
    private String description;

    @NotNull(message = "Capacity ID cannot be empty")
    @Max(value = 40, message = "Capacity must be 40 or less")
    private int capacity;
}
