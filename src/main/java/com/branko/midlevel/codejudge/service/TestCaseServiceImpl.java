package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.mapper.TestCaseMapper;
import com.branko.midlevel.codejudge.repository.TestCaseRepository;
import com.branko.midlevel.codejudge.repository.entity.TestCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final TestCaseMapper testCaseMapper;

    @Override
    public TestCaseDto createTestCase(TestCase testCase) {
        return testCaseMapper.TestCaseDtoFromMapCreateTestCase(testCaseRepository.save(testCase));
    }

    @Override
    public List<TestCaseDto> getTestCaseByProblemId(Long problemId) {
        return testCaseMapper.testCaseDtoListFromTestCaseList(testCaseRepository.findByProblemId(problemId));
    }
}
