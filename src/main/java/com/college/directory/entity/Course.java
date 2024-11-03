package com.college.directory.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private FacultyProfile faculty;

    @ManyToMany(mappedBy = "courses")
    private Set<StudentProfile> students = new HashSet<>();

    // Constructors
    public Course() {}

    public Course(String title, String description, Department department, FacultyProfile faculty) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.faculty = faculty;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public FacultyProfile getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyProfile faculty) {
        this.faculty = faculty;
    }

    public Set<StudentProfile> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentProfile> students) {
        this.students = students;
    }
}
