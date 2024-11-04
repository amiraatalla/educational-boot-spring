package com.amira.educational.system.alemny.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String grade;

    @Column(nullable = false)
    private String session;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = true)
    private String type;

    // العلاقة بين Subject و Unit (OneToMany)
    @OneToMany(mappedBy = "subject")
    private List<Unit> units ;

    // العلاقة بين Subject و Exam (OneToMany)
    @OneToMany(mappedBy = "subject")
    private List<Exam> exams;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    }
