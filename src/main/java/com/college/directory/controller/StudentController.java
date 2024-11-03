package com.college.directory.controller;

import com.college.directory.entity.StudentProfile;
import com.college.directory.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Endpoint to get a student's profile
    @GetMapping("/{userId}")
    public ResponseEntity<StudentProfile> getStudentProfile(@PathVariable Long userId) {
        Optional<StudentProfile> profile = studentService.getStudentProfile(userId);
        return profile.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to search for students
    @GetMapping("/search")
    public ResponseEntity<List<StudentProfile>> searchStudents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String year) {
        List<StudentProfile> students = studentService.searchStudents(name, department, year);
        return ResponseEntity.ok(students);
    }
}
