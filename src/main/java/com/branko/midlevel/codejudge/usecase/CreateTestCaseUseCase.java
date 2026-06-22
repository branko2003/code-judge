package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.dto.request.CreateTestCaseRequest;
import com.branko.midlevel.codejudge.dto.response.TestCaseResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.ProblemMapper;
import com.branko.midlevel.codejudge.mapper.TestCaseMapper;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.Problem;
import com.branko.midlevel.codejudge.repository.entity.TestCase;
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
    private final ProblemMapper problemMapper;
    private final MessageUtil messageUtil;

    public TestCaseResponse execute(CreateTestCaseRequest request) {
        ProblemDto problemDto = validateProblem(request.getProblemId());
        TestCase testCaseInsert = testCaseMapper.TestCaseFromMapCreateTestCaseRequest(request);
        testCaseInsert.setProblem(problemMapper.problemFromProblemDto(problemDto));
        TestCaseDto testCase = testCaseService.createTestCase(testCaseInsert);
        return new TestCaseResponse(testCase);
    }

    private ProblemDto validateProblem(Long problemId) {
        ProblemDto problem = problemService.getById(problemId);
        if (problem == null) {
            throw new BadRequestException(messageUtil.get("problem.notfound"));
        }
        return problem;
    }
}
