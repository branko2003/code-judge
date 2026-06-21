package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.usecase.SubmitSubmissionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmitSubmissionUseCase submitSubmissionUseCase;

    @PostMapping("/SubmitSubmission")
    public CommonResponse submitSubmission(@Valid @RequestBody SubmitSumissionRequest request) {
        return submitSubmissionUseCase.execute(request);
    }
}
