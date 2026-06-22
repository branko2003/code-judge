package com.branko.midlevel.codejudge.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "submission_results")
@Getter
@Setter
public class SubmissionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testcase_id", nullable = false)
    private TestCase testCase;

    private String veredict;

    private String actualOutput;
}