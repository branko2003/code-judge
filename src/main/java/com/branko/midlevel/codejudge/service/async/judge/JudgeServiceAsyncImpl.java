package com.branko.midlevel.codejudge.service.async.judge;

import com.branko.midlevel.codejudge.dto.other.SubmissionDto;
import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.mapper.SubmissionMapper;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import com.branko.midlevel.codejudge.service.JudgeService;
import com.branko.midlevel.codejudge.service.SubmissionService;
import com.branko.midlevel.codejudge.service.TestCaseService;
import com.branko.midlevel.codejudge.service.strategy.judgestrategy.JudgeStrategy;
import com.branko.midlevel.codejudge.service.strategy.judgestrategy.JudgeStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JudgeServiceAsyncImpl implements JudgeServiceAsync {

    private final JudgeStrategyFactory judgeStrategyFactory;
    private final TestCaseService testCaseService;
    private final SubmissionMapper submissionMapper;
    private final JudgeService judgeService;
    private final SubmissionService submissionService;

    @Async("judgeExecutor")
    public void processSubmission(SubmissionDto submissionDto, Long problemId) {
        List<TestCaseDto> testCases = testCaseService.getTestCaseByProblemId(problemId);
        JudgeStrategy judgeStrategy = judgeStrategyFactory.findStrategy(submissionDto.getLanguage());
        Submission submission = submissionMapper.submissionFromMapSubmissionDto(submissionDto);
        SubmissionUpdate result = judgeService.evaluate(
                judgeStrategy,
                submissionDto.getSourceCode(),
                testCases,
                submission
        );

        submissionService.updateSubmission(submission.getId(), result);
    }
}
