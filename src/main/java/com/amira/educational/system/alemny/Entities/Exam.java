package com.amira.educational.system.alemny.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;  // عنوان الامتحان

    @Column(nullable = false)
    private LocalDateTime examDate;  // تاريخ ووقت الامتحان

    @Column(nullable = false)
    private String description;  // وصف الامتحان (مثال: امتحان نهاية الفصل الدراسي)

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;  // المادة المرتبطة بالامتحان

    @Column(nullable = false)
    private String url;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
   }
