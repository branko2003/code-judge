package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.repository.entity.TestCase;

import java.util.List;

public interface TestCaseService {

    TestCaseDto createTestCase(TestCase testCase);

    List<TestCaseDto> getTestCaseByProblemId(Long problemId);

}
