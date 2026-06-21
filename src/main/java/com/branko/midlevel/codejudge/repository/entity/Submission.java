package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "submissions")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Problem problem;

    @ManyToOne
    private Contest contest;

    @Lob
    private String sourceCode;

    private String language;

    private String verdict;

    private Date submittedAt;
}