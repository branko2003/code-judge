package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10000)
    private String description;

    @Column(nullable = false, length = 5000)
    private String inputDescription;

    @Column(nullable = false, length = 5000)
    private String outputDescription;

    @Column(length = 5000)
    private String sampleInput;

    @Column(length = 5000)
    private String sampleOutput;
}