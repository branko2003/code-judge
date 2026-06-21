package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String role;

    private String username;

    private String password;

}
