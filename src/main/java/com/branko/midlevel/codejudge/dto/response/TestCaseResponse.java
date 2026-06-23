package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;
import lombok.Getter;

@Getter
public class TestCaseResponse extends CommonResponse {

    private TestCaseDto testCase;

    public TestCaseResponse(TestCaseDto testCase) {
        super();
        this.testCase = testCase;
    }
}
