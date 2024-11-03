package com.college.directory.service;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.entity.StudentProfile;
import com.college.directory.repository.FacultyProfileRepository;
import com.college.directory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    // Create or update student profile
    public StudentProfile saveStudentProfile(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    // Delete student profile by ID
    public void deleteStudentProfile(Long userId) {
        studentProfileRepository.deleteById(userId);
    }

    // Create or update faculty profile
    public FacultyProfile saveFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    // Delete faculty profile by ID
    public void deleteFacultyProfile(Long userId) {
        facultyProfileRepository.deleteById(userId);
    }

    // Get lists for dashboard data (simple example)
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    public List<FacultyProfile> getAllFaculty() {
        return facultyProfileRepository.findAll();
    }
}
