package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "{userUsername.notblank}")
    private String username;

    @NotBlank(message = "{userPassword.notblank}")
    private String password;
}
