package com.branko.midlevel.codejudge.dto.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResultUserDto {

    private Long TotalTestCase;
    private Long PassedTestCase;
    private List<SubmissionResultDto> submissionDtoList;
}
