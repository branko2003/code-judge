package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;

public class ProblemResponse extends CommonResponse {

    private ProblemDto problem;

    public ProblemResponse(ProblemDto problem) {
        super(ApiResponseConstant.SUCCESS_CODE, ApiResponseConstant.SUCCESS_MSG);
        this.problem = problem;
    }
}
