package com.college.directory.repository;

import com.college.directory.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {
    StudentProfile findByFacultyId(Long facultyId);
    List<StudentProfile> searchByFilters(String name, String department, String year);

}
