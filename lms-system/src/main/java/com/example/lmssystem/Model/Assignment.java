package com.example.lmssystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Assignment {
    @NotEmpty(message = "ID cannot be empty")
    private String id;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dueDate;

    private Course course;

}
