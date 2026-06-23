package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.dto.request.CreateTestCaseRequest;
import com.branko.midlevel.codejudge.repository.entity.TestCase;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestCaseMapper {

    TestCase TestCaseFromMapCreateTestCaseRequest(CreateTestCaseRequest createTestCaseRequest);

    TestCaseDto TestCaseDtoFromMapCreateTestCase(TestCase testCase);

    List<TestCaseDto> testCaseDtoListFromTestCaseList(List<TestCase> testCases);

    TestCase TestCaseFromMapCreateTestCaseDto(TestCaseDto testCase);
}
