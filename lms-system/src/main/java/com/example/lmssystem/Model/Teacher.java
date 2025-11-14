package com.example.lmssystem.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "ID cannot be empty")
    private String id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Salary cannot be empty")
    private double salary;
}
