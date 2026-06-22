package com.branko.midlevel.codejudge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubmissionResultByContestResponse extends CommonResponse {

    private List<SubmissionResultResponse> submissionResultResponseList;
}
