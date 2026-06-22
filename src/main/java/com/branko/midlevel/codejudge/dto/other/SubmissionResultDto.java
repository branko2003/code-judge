package com.branko.midlevel.codejudge.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResultDto {

    private Long id;
    private TestCaseDto testCase;
    private String veredict;
    private String actualOutput;
}
