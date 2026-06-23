package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.request.SumissionResultContestByUserRequest;
import com.branko.midlevel.codejudge.dto.request.SumissionResultRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.dto.response.SubmissionResultResponse;
import com.branko.midlevel.codejudge.usecase.submission.SubmissionResultContestByUserUseCase;
import com.branko.midlevel.codejudge.usecase.submission.SubmissionResultContestUseCase;
import com.branko.midlevel.codejudge.usecase.submission.SubmitSubmissionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmitSubmissionUseCase submitSubmissionUseCase;
    private final SubmissionResultContestUseCase submissionResultContestUseCase;
    private final SubmissionResultContestByUserUseCase submissionResultContestByUserUseCase;

    @PostMapping("/SubmitSubmission")
    public CommonResponse submitSubmission(@Valid @RequestBody SubmitSumissionRequest request) {
        return submitSubmissionUseCase.execute(request);
    }

    @PostMapping("/SubmissionResultProblem")
    public SubmissionResultResponse submissionResult(@Valid @RequestBody SumissionResultRequest request) {
        return submissionResultContestUseCase.execute(request);
    }

    @PostMapping("/SubmissionResultContestByUser")
    public SubmissionResultResponse submissionResultContestByUser(@Valid @RequestBody SumissionResultContestByUserRequest request) {
        return submissionResultContestByUserUseCase.execute(request);
    }
}
