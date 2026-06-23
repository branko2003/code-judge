package com.branko.midlevel.codejudge.usecase.user;

import com.branko.midlevel.codejudge.constant.RoleEnum;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.CreateUserRequest;
import com.branko.midlevel.codejudge.dto.response.UserResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.entity.User;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final MessageUtil messageUtil;

    public UserResponse execute(CreateUserRequest request) {
        this.validateUser(request);
        User userToCreate = userMapper.userFromCreateUserRequest(request);
        userToCreate.setPassword(passwordEncoder.encode(request.getPassword()));
        UserDto userSave = userService.createUser(userToCreate);
        return new UserResponse(userSave);

    }

    private void validateUser(CreateUserRequest request) {
        if (!RoleEnum.isAllowedRol(request.getRole())) {
            throw new BadRequestException(messageUtil.get("invalid.role"));
        }
    }
}
