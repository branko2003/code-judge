package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import lombok.Getter;

@Getter
public class UserResponse extends CommonResponse {

    private UserDto user;

    public UserResponse(UserDto user) {
        super();
        this.user = user;
    }
}
