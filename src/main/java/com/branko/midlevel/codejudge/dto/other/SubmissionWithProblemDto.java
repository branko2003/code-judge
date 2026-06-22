package com.branko.midlevel.codejudge.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionWithProblemDto {

    private Long id;
    private UserDto user;
    private ProblemDto problem;
    private String sourceCode;
    private String language;
}
