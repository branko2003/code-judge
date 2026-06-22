package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    @NotBlank(message = "{userName.notblank}")
    private String name;

    @NotBlank(message = "{userLastname.notblank}")
    private String lastname;

    @NotBlank(message = "{userRole.notblank}")
    private String role;

    //@NotBlank(message = "{userUsername.notblank}")
    private String username;

    //@NotBlank(message = "{userPassword.notblank}")
    private String password;

}
