package com.example.lmssystem.Controller;

import com.example.lmssystem.Api.ApiResponse;
import com.example.lmssystem.Model.Assignment;
import com.example.lmssystem.Service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/assignment")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;


    @GetMapping("/get")
    public ResponseEntity<?> getAssignments () {
        if (assignmentService.getAssignments().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse("No assignment found"));
        }
        return ResponseEntity.status(200).body(assignmentService.getAssignments());
    }



    @PostMapping("/add")
    public ResponseEntity<?> addAssignment (@RequestBody @Valid Assignment assignment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        assignmentService.addAssignment(assignment);
        return ResponseEntity.status(200).body(new ApiResponse("Assignment added successfully"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAssignment (@PathVariable String id, @RequestBody @Valid Assignment assignment, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        if (assignmentService.updateAssignment(id, assignment)) {
            return ResponseEntity.status(200).body(new ApiResponse("Assignment updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Assignment not found"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse (@PathVariable String id) {
        if (assignmentService.deleteAssignment(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("Assignment deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Assignment not found"));
    }



    @GetMapping("/get-assignment-course/{id}")
    public ResponseEntity<?> getAssignmentByCourseId (@PathVariable String id) {
        if (assignmentService.getAssignmentByCourseId(id).isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse(" No assignment found"));
        }
        return ResponseEntity.status(200).body(assignmentService.getAssignmentByCourseId(id));
    }



    @GetMapping("/get-expired")
    public ResponseEntity<?> getExpiredAssignment () {
        if (assignmentService.getExpiredAssignment().isEmpty()) {
            return ResponseEntity.status(400).body(new ApiResponse(" No assignment found"));
        }
        return ResponseEntity.status(200).body(assignmentService.getExpiredAssignment());
    }



    @GetMapping("/get-id/{id}")
    public ResponseEntity<?> getAssignmentsById (@PathVariable String id) {
        if (assignmentService.getAssignmentsById(id) == null) {
            return ResponseEntity.status(400).body(new ApiResponse(" No assignment found"));
        }
        return ResponseEntity.status(200).body(assignmentService.getAssignmentsById(id));
    }



    @PutMapping("update-title/{id}/{title}")
    public ResponseEntity<?> updateTitle (@PathVariable String id, @PathVariable String title) {
        if (assignmentService.updateTitle(id, title)) {
            return ResponseEntity.status(200).body(new ApiResponse("Title updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Assignment not found"));
    }

    }
