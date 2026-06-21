package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import com.branko.midlevel.codejudge.dto.request.CreateTestCaseRequest;
import com.branko.midlevel.codejudge.repository.entity.TestCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestCaseMapper {

    TestCase TestCaseFromMapCreateTestCaseRequest(CreateTestCaseRequest createTestCaseRequest);

    TestCaseDto TestCaseDtoFromMapCreateTestCase(TestCase testCase);
}
