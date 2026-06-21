package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.ContestDto;

public class AddUsersToContestResponse extends CommonResponse {


    public AddUsersToContestResponse() {
        super(ApiResponseConstant.SUCCESS_CODE, ApiResponseConstant.SUCCESS_MSG);
    }
}
