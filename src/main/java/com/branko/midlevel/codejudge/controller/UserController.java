package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.CreateUserRequest;
import com.branko.midlevel.codejudge.dto.response.UserResponse;
import com.branko.midlevel.codejudge.usecase.user.CreateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    @PostMapping(value = "/CreateUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return createUserUseCase.execute(request);
    }
}
