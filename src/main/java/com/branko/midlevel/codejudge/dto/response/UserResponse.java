package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.UserDto;

public class UserResponse extends CommonResponse {

    private UserDto user;

    public UserResponse(UserDto user) {
        super(ApiResponseConstant.SUCCESS_CODE, ApiResponseConstant.SUCCESS_MSG);
        this.user = user;
    }
}
