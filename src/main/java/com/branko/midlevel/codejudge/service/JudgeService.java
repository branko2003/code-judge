package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.SubmissionUpdate;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.repository.entity.Submission;
import com.branko.midlevel.codejudge.service.strategy.judgestrategy.JudgeStrategy;

import java.util.List;

public interface JudgeService {

    SubmissionUpdate evaluate(JudgeStrategy strategy, String sourceCode, List<TestCaseDto> testCases, Submission submission);
}
