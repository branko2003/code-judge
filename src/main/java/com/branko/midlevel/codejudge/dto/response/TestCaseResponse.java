package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.TestCaseDto;

public class TestCaseResponse extends CommonResponse {

    private TestCaseDto testCase;

    public TestCaseResponse(TestCaseDto testCase) {
        super(ApiResponseConstant.SUCCESS_CODE, ApiResponseConstant.SUCCESS_MSG);
        this.testCase = testCase;
    }
}
