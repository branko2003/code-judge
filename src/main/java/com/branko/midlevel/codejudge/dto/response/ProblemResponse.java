package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.ProblemDto;
import lombok.Getter;

@Getter
public class ProblemResponse extends CommonResponse {

    private ProblemDto problem;

    public ProblemResponse(ProblemDto problem) {
        super();
        this.problem = problem;
    }
}
