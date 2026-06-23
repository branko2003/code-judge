package com.branko.midlevel.codejudge.controller;

import com.branko.midlevel.codejudge.dto.request.LoginRequest;
import com.branko.midlevel.codejudge.dto.response.AuthResponse;
import com.branko.midlevel.codejudge.usecase.LoginUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUseCase loginUseCase;

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return loginUseCase.execute(request);
    }
}
