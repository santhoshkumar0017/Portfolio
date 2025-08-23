package com.courseregisration.cr_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String courseName;
    @Column(nullable = false)
    private String trainerName;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String urlImg;
}
