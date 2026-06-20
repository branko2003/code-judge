package com.branko.midlevel.codejudge.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateUserRequest {

    @NotBlank
    private  String userId;

    private String name;

    private String lastname;

    private String role;

    private String username;

    private String password;
}
