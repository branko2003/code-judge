package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.ContestDto;
import lombok.Getter;

@Getter
public class ContestResponse extends CommonResponse {
    private ContestDto contest;

    public ContestResponse(ContestDto contest) {
        super();
        this.contest = contest;
    }
}
