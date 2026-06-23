package com.branko.midlevel.codejudge.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubmissionProblem {

    private ProblemDto problem;
    private SubmissionResultUserDto submissionResult;
}
