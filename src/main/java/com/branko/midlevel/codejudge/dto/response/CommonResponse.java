package com.branko.midlevel.codejudge.dto.response;

import com.branko.midlevel.codejudge.constant.ApiResponseConstant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse {

    private String statusCode;
    private String message;

    public CommonResponse() {
        this.statusCode = ApiResponseConstant.SUCCESS_CODE;
        this.message = ApiResponseConstant.SUCCESS_MSG;
    }
}
