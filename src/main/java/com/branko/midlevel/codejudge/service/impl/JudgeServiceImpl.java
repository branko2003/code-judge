package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.constant.VeredictEnum;
import com.branko.midlevel.codejudge.dto.other.ExecutionResult;
import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.mapper.TestCaseMapper;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import com.branko.midlevel.codejudge.repository.entity.SubmissionResult;
import com.branko.midlevel.codejudge.service.JudgeService;
import com.branko.midlevel.codejudge.service.ProcessExecutorService;
import com.branko.midlevel.codejudge.service.SubmissionResultService;
import com.branko.midlevel.codejudge.service.strategy.judgestrategy.JudgeStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JudgeServiceImpl implements JudgeService {

    private final ProcessExecutorService processExecutorService;
    private final SubmissionResultService submissionResultService;
    private final TestCaseMapper testCaseMapper;

    public SubmissionUpdate evaluate(JudgeStrategy strategy, String sourceCode, List<TestCaseDto> testCases, Submission submission) {
        int passed = 0;
        try {
            Path dir = Files.createTempDirectory("judge");
            Path file = strategy.createFile(dir, sourceCode);
            List<String> compileCmd = strategy.compileCommand(file);

            if (compileCmd != null) {
                ExecutionResult compileResult = processExecutorService.run(compileCmd, dir, "");

                if (compileResult.getExitCode() != 0) {
                    saveAll(testCases, submission, VeredictEnum.COMPILATION_ERROR.get());
                    return buildSubmissionUpdate(0, testCases.size());
                }
            }

            for (TestCaseDto tc : testCases) {
                ExecutionResult result = processExecutorService.run(strategy.runCommand(file), dir, tc.getInputData());
                String actual = normalize(result.getOutput());
                String expected = normalize(tc.getExpectedOutput());
                String verdict = veredictResult(result, expected, actual);
                saveResult(submission, tc, verdict, actual);

                if (verdict.equals(VeredictEnum.ACCEPTED.get())) {
                    passed++;
                }
            }

            return buildSubmissionUpdate(passed, testCases.size());

        } catch (Exception e) {
            return buildSubmissionUpdate(0, testCases.size());
        }
    }

    private void saveResult(
            Submission submission,
            TestCaseDto testCase,
            String verdict,
            String actual
    ) {
        SubmissionResult result = new SubmissionResult();
        result.setSubmission(submission);
        result.setTestCase(testCaseMapper.TestCaseFromMapCreateTestCaseDto(testCase));
        result.setVeredict(verdict);
        result.setActualOutput(actual);
        submissionResultService.createSubmissionResult(result);
    }

    private void saveAll(List<TestCaseDto> testCases, Submission submission, String verdict) {
        for (TestCaseDto tc : testCases) {
            saveResult(submission, tc, verdict, null);
        }
    }

    private SubmissionUpdate buildSubmissionUpdate(int passed, int total) {
        SubmissionUpdate submissionUpdate = new SubmissionUpdate();
        submissionUpdate.setPassed(passed);
        submissionUpdate.setTotal(total);
        return submissionUpdate;
    }

    private String normalize(String s) {
        return s == null ? "" : s.trim().replace("\r\n", "\n");
    }

    private String veredictResult(ExecutionResult result, String expected, String actual) {

        if (result.getExitCode() != 0) {
            return VeredictEnum.RUNTIME_ERROR.get();
        }

        if (!actual.equals(expected)) {
            return VeredictEnum.WRONG_ANSWER.get();
        }

        return VeredictEnum.ACCEPTED.get();
    }
}
