package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.CreateUserRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.dto.response.UserResponse;
import com.branko.midlevel.codejudge.usecase.CreateUserUseCase;
import com.branko.midlevel.codejudge.usecase.UpdateUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping("/CreateUser")
    public UserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return createUserUseCase.execute(request);
    }

    @PostMapping("/UpdateUser")
    public UserResponse updateUser(@Valid @RequestBody UpdateUserRequest request) {
        return updateUserUseCase.execute(request);
    }
/*
    @PostMapping("/createParticipant")
    public UserResponse createParticipant(@Valid @RequestBody CreateUserRequest request) {
        return createUserUseCase.execute(request);
    }
*/
}
