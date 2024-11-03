package com.college.directory.controller;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.entity.StudentProfile;
import com.college.directory.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // Endpoint to get faculty profile
    @GetMapping("/{userId}")
    public ResponseEntity<FacultyProfile> getFacultyProfile(@PathVariable Long userId) {
        Optional<FacultyProfile> profile = facultyService.getFacultyProfile(userId);
        return profile.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to update faculty profile
    @PutMapping("/{userId}")
    public ResponseEntity<FacultyProfile> updateFacultyProfile(@PathVariable Long userId, @RequestBody FacultyProfile updatedProfile) {
        updatedProfile.setUserId(userId);
        FacultyProfile profile = facultyService.updateFacultyProfile(updatedProfile);
        return ResponseEntity.ok(profile);
    }

    // Endpoint to get the class list of students in faculty's course
    @GetMapping("/{facultyId}/class-list")
    public ResponseEntity<List<StudentProfile>> getClassList(@PathVariable Long facultyId) {
        List<StudentProfile> students = facultyService.getClassList(facultyId);
        return ResponseEntity.ok(students);
    }
}
