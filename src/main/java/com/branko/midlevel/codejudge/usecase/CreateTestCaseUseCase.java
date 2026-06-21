package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.dto.request.CreateTestCaseRequest;
import com.branko.midlevel.codejudge.dto.response.TestCaseResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.mapper.TestCaseMapper;
import com.branko.midlevel.codejudge.service.ProblemService;
import com.branko.midlevel.codejudge.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateTestCaseUseCase {

    private final TestCaseService testCaseService;
    private final TestCaseMapper testCaseMapper;
    private final ProblemService problemService;

    public TestCaseResponse execute(CreateTestCaseRequest request) {
        validate(request);
        TestCaseDto testCase = testCaseService.createTestCase(testCaseMapper.TestCaseFromMapCreateTestCaseRequest(request));
        return new TestCaseResponse(testCase);
    }

    private void validate(CreateTestCaseRequest request) {
        ProblemDto problem = problemService.getById(request.getProblemId());
        if (problem == null) {
            throw new BadRequestException("");
        }
    }
}
