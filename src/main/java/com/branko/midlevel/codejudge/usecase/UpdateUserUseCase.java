package com.branko.midlevel.codejudge.usecase;

import com.branko.midlevel.codejudge.constant.RoleEnum;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.dto.response.UserResponse;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.entity.User;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserResponse execute(UpdateUserRequest request) {
        User user = this.validateUser(request);
        //User userToUpdate = userMapper.userFromMapUpdateUserRequest(request, user);
        UserDto userUpdate = userService.updateUser(user);
        return new UserResponse(userUpdate);

    }

    private User validateUser(UpdateUserRequest request) {
        if (!RoleEnum.isAllowedRol(request.getRole())) {
            throw new RuntimeException("Invalid role");
        }
        User user = userService.getById(request.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
