package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.dto.other.UserAuth;
import com.branko.midlevel.codejudge.dto.request.LoginRequest;
import com.branko.midlevel.codejudge.dto.response.AuthResponse;
import com.branko.midlevel.codejudge.security.CustomUserDetails;
import com.branko.midlevel.codejudge.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUseCase {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthResponse execute(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        UserAuth userDto = user.getUser();
        String token = jwtService.generateToken(userDto);

        return new AuthResponse(
                token,
                userDto.getId(),
                userDto.getRole()
        );
    }
}
