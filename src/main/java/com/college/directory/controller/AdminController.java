package com.college.directory.controller;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.entity.StudentProfile;
import com.college.directory.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint to create or update student profile
    @PostMapping("/students")
    public ResponseEntity<StudentProfile> createOrUpdateStudent(@RequestBody StudentProfile studentProfile) {
        StudentProfile savedProfile = adminService.saveStudentProfile(studentProfile);
        return ResponseEntity.ok(savedProfile);
    }

    // Endpoint to delete student profile
    @DeleteMapping("/students/{userId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long userId) {
        adminService.deleteStudentProfile(userId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to create or update faculty profile
    @PostMapping("/faculty")
    public ResponseEntity<FacultyProfile> createOrUpdateFaculty(@RequestBody FacultyProfile facultyProfile) {
        FacultyProfile savedProfile = adminService.saveFacultyProfile(facultyProfile);
        return ResponseEntity.ok(savedProfile);
    }

    // Endpoint to delete faculty profile
    @DeleteMapping("/faculty/{userId}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long userId) {
        adminService.deleteFacultyProfile(userId);
        return ResponseEntity.noContent().build();
    }

    // Endpoint to get dashboard data for students
    @GetMapping("/dashboard/students")
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        List<StudentProfile> students = adminService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Endpoint to get dashboard data for faculty
    @GetMapping("/dashboard/faculty")
    public ResponseEntity<List<FacultyProfile>> getAllFaculty() {
        List<FacultyProfile> faculty = adminService.getAllFaculty();
        return ResponseEntity.ok(faculty);
    }
}
