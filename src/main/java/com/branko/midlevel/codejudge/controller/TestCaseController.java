package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.CreateTestCaseRequest;
import com.branko.midlevel.codejudge.dto.request.SubmitSumissionRequest;
import com.branko.midlevel.codejudge.dto.response.CommonResponse;
import com.branko.midlevel.codejudge.dto.response.TestCaseResponse;
import com.branko.midlevel.codejudge.usecase.CreateTestCaseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestCaseController {

    private final CreateTestCaseUseCase createTestCaseUseCase;

    @PostMapping("/CreateTestCase")
    public TestCaseResponse createTestCase(@Valid @RequestBody CreateTestCaseRequest request) {
        return createTestCaseUseCase.execute(request);
    }
}
