package com.branko.midlevel.codejudge.usecase.user;

import com.branko.midlevel.codejudge.constant.RoleEnum;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.dto.response.UserResponse;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserService userService;
    private final UserMapper userMapper;
    private final MessageUtil messageUtil;

    public UserResponse execute(UpdateUserRequest request) {
        UserDto user = this.validateUser(request);
        //User userToUpdate = userMapper.userFromMapUpdateUserRequest(request, user);
        //UserDto userUpdate = userService.updateUser(user);
        return new UserResponse(null);

    }

    private UserDto validateUser(UpdateUserRequest request) {
        if (!RoleEnum.isAllowedRol(request.getRole())) {
            throw new BadRequestException(messageUtil.get("invalid.role"));
        }
        UserDto user = userService.getById(request.getUserId());
        if (user == null) {
            throw new BadRequestException(messageUtil.get("user.notfound"));
        }
        return user;
    }
}
