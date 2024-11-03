package com.college.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.college.directory")
public class CollegeDirectoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollegeDirectoryApplication.class, args);
    }
}
