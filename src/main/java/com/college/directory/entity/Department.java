package com.college.directory.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StudentProfile> students = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FacultyProfile> facultyMembers = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AdministratorProfile> administrators = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    // Constructors
    public Department() {}

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<StudentProfile> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentProfile> students) {
        this.students = students;
    }

    public Set<FacultyProfile> getFacultyMembers() {
        return facultyMembers;
    }

    public void setFacultyMembers(Set<FacultyProfile> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    public Set<AdministratorProfile> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Set<AdministratorProfile> administrators) {
        this.administrators = administrators;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
