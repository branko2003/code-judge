package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.ContestDto;

public class ContestResponse extends CommonResponse {
    private ContestDto contest;

    public ContestResponse(ContestDto contest) {
        super(ApiResponseConstant.SUCCESS_CODE, ApiResponseConstant.SUCCESS_MSG);
        this.contest = contest;
    }
}
