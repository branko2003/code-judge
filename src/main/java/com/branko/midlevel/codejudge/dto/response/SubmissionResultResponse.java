package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.dto.other.SubmissionProblem;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubmissionResultResponse extends CommonResponse {

    private UserDto user;
    private List<SubmissionProblem> submissionProblemList;
}
