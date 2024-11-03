package com.college.directory.service;

import com.college.directory.entity.FacultyProfile;
import com.college.directory.entity.StudentProfile;
import com.college.directory.repository.FacultyProfileRepository;
import com.college.directory.repository.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    // Get faculty profile by user ID
    public Optional<FacultyProfile> getFacultyProfile(Long userId) {
        return facultyProfileRepository.findById(userId);
    }

    // Update faculty profile details (e.g., office hours)
    public FacultyProfile updateFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    // Get students in a faculty member's course
    public List<StudentProfile> getClassList(Long facultyId) {
        return (List<StudentProfile>) studentProfileRepository.findByFacultyId(facultyId);
    }
}
