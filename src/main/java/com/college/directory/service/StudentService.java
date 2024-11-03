package com.college.directory.service;

import com.college.directory.entity.StudentProfile;
import com.college.directory.entity.User;
import com.college.directory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    // Get student profile by user ID
    public Optional<StudentProfile> getStudentProfile(Long userId) {
        return studentProfileRepository.findById(userId);
    }

    // Search for students by name, department, or year
    public List<StudentProfile> searchStudents(String name, String department, String year) {
        return studentProfileRepository.searchByFilters(name, department, year);
    }
}
