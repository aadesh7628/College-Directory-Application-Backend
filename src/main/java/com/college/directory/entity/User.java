//package com.college.directory.entity;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    private String phone;
//
//    public enum Role {
//        STUDENT,
//        FACULTY_MEMBER,
//        ADMINISTRATOR
//    }
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private StudentProfile studentProfile;
//    
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private FacultyProfile facultyProfile;
//    
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private AdministratorProfile administratorProfile;
//    
//    @OneToMany(fetch = FetchType.EAGER)
//    private Collection<GrantedAuthority> authorities;
//    
// // Constructor with fields (excluding relationships for simplicity)
//    public User(String username, String password, Role role, String name, String email, String phone) {
//        this.username = username;
//        this.password = password;
//        this.role = role;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//    }
//
//    // Default constructor
//    public User() {}
//
//    //Getters and Setter
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public StudentProfile getStudentProfile() {
//		return studentProfile;
//	}
//
//	public void setStudentProfile(StudentProfile studentProfile) {
//		this.studentProfile = studentProfile;
//	}
//
//	public FacultyProfile getFacultyProfile() {
//		return facultyProfile;
//	}
//
//	public void setFacultyProfile(FacultyProfile facultyProfile) {
//		this.facultyProfile = facultyProfile;
//	}
//
//	public AdministratorProfile getAdministratorProfile() {
//		return administratorProfile;
//	}
//
//	public void setAdministratorProfile(AdministratorProfile administratorProfile) {
//		this.administratorProfile = administratorProfile;
//	}
//
////	public Collection<GrantedAuthority> getAuthorities() {
////		return authorities;
////	}
//
//	public void setAuthorities(Collection<GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return authorities;
//	}
//
//    
//    
//}

package com.college.directory.entity;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    public enum Role {
        STUDENT,
        FACULTY_MEMBER,
        ADMINISTRATOR
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StudentProfile studentProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private FacultyProfile facultyProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AdministratorProfile administratorProfile;

    // Constructor with fields
    public User(String username, String password, Role role, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Default constructor
    public User() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyProfile;
    }

    public void setFacultyProfile(FacultyProfile facultyProfile) {
        this.facultyProfile = facultyProfile;
    }

    public AdministratorProfile getAdministratorProfile() {
        return administratorProfile;
    }

    public void setAdministratorProfile(AdministratorProfile administratorProfile) {
        this.administratorProfile = administratorProfile;
    }

    // Implementing UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Replace this with actual authorities based on your role
        return Collections.singletonList((GrantedAuthority) () -> role.name());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic for enabling/disabling users
    }
}

