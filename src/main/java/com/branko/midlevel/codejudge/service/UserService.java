package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.repository.entity.User;

public interface UserService {

    UserDto createUser(User user);

    UserDto updateUser(User user);

    User getById(String userId);
}
