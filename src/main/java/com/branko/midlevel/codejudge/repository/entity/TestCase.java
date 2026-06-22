package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "test_cases")
@Getter
@Setter
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    private String inputData;

    private String expectedOutput;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column()
    private LocalDateTime updatedAt;
}