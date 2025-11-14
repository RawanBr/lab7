package com.example.lmssystem.Controller;

import com.example.lmssystem.Api.ApiResponse;
import com.example.lmssystem.Model.Teacher;
import com.example.lmssystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity<?> getTeachers () {
        if (teacherService.getTeachers().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No teacher found"));
        }
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }



    @PostMapping("/add")
    public ResponseEntity<?> addTeacher (@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTeacher (@PathVariable String id, @RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if (teacherService.updateTeacher(id, teacher)) {
            return ResponseEntity.status(200).body(new ApiResponse("Teacher updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not found"));
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTeacher (@PathVariable String id) {
        if (teacherService.deleteTeacher(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Teacher added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not found"));
    }



    @GetMapping("/get-id/{id}")
    public ResponseEntity<?> getTeacherById (@PathVariable String id) {
        if (teacherService.getTeacherById(id) == null) {
            return ResponseEntity.status(400).body(new ApiResponse("No teacher found"));
        }
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }


    @GetMapping("/get-salary/{salary}")
    public ResponseEntity<?> getTeacherBySalary (@PathVariable double salary) {
        if (teacherService.getTeacherBySalary(salary).isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No teacher found"));
        }
        return ResponseEntity.status(200).body(teacherService.getTeacherBySalary(salary));
    }
}

