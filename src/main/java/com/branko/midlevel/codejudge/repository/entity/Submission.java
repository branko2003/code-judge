package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "submissions")
@Getter
@Setter
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContestProblem contestProblem;

    @Column(columnDefinition = "TEXT")
    private String sourceCode;

    private String language;

    private Integer passed;

    private Integer total;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime submittedAt;
}