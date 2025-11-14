package com.example.lmssystem.Controller;

import com.example.lmssystem.Api.ApiResponse;
import com.example.lmssystem.Model.Course;
import com.example.lmssystem.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity<?> getCourses () {
        if (courseService.getCourses().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No course found"));
        }
        return ResponseEntity.status(200).body(courseService.getCourses());
    }



    @PostMapping("/add")
    public ResponseEntity<?> addCourse (@RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added successfully"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse (@PathVariable String id, @RequestBody @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        if (courseService.updateCourse(id, course)) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse (@PathVariable String id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
    }



    @GetMapping("/get-category/{category}")
    public ResponseEntity<?> getByCategory (@PathVariable String category) {
        if (courseService.getByCategory(category).isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(courseService.getByCategory(category));
    }



    @GetMapping("/get-teacher/{id}")
    public ResponseEntity<?> getCourseTeacher (@PathVariable String id) {
        if (courseService.getCourseTeacher(id) == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(courseService.getCourseTeacher(id));
    }



    @GetMapping("/get-capacity/{min}/{max}")
    public ResponseEntity<?> getByCapacity (@PathVariable int min, @PathVariable int max) {
        if (courseService.getByCapacity(min, max).isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(courseService.getByCapacity(min, max));
    }



    @PutMapping("/update-capacity/{id}/{capacity}")
    public ResponseEntity<?> updateCapacity (@PathVariable String id, @PathVariable int capacity) {
        if (courseService.updateCapacity(id, capacity)) {
            return ResponseEntity.status(200).body(new ApiResponse("Capacity updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
    }

    }
