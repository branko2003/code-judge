package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.UserRepository;
import com.branko.midlevel.codejudge.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto createUser(User user) {
        return userMapper.userDtoFromMapUser(userRepository.save(user));
    }

    @Override
    public UserDto updateUser(User user) {
        return userMapper.userDtoFromMapUser(userRepository.save(user));
    }

    @Override
    public User getById(String userId) {
        return userRepository.getById(userId);
    }
}
