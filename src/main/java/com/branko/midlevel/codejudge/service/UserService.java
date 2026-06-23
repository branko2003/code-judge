package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.UserAuth;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.repository.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(User user);

    UserDto updateUser(String userId, UpdateUserRequest request);

    UserDto getById(String userId);

    List<UserDto> getUsersByIds(List<String> userIds);
}
