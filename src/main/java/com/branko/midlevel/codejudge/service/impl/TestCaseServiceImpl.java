package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.mapper.TestCaseMapper;
import com.branko.midlevel.codejudge.repository.TestCaseRepository;
import com.branko.midlevel.codejudge.repository.entity.TestCase;
import com.branko.midlevel.codejudge.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final TestCaseMapper testCaseMapper;

    @Override
    @CacheEvict(cacheNames = "testCaseByProblem", key = "{#testCase.problem.getId().toString()}")
    public TestCaseDto createTestCase(TestCase testCase) {
        return testCaseMapper.TestCaseDtoFromMapCreateTestCase(testCaseRepository.save(testCase));
    }

    @Override
    @Cacheable(cacheNames = "testCaseByProblem", key = "{#problemId.toString()}")
    public List<TestCaseDto> getTestCaseByProblemId(Long problemId) {
        return testCaseMapper.testCaseDtoListFromTestCaseList(testCaseRepository.findByProblemId(problemId));
    }
}
