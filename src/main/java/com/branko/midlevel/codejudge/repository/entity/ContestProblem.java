package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contest_problems")
public class ContestProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Contest contest;

    @ManyToOne
    private Problem problem;

    private Integer position;
}