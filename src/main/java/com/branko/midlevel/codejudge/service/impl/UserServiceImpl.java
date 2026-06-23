package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.UserAuth;
import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.UserRepository;
import com.branko.midlevel.codejudge.repository.entity.User;
import com.branko.midlevel.codejudge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MessageUtil messageUtil;

    @Override
    public UserDto createUser(User user) {
        return userMapper.userDtoFromUser(userRepository.save(user));
    }

    @Override
    @CachePut(cacheNames = "user", key = "{#userId}")
    public UserDto updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException(messageUtil.get("user.notfound")));
        userMapper.updateUserFromRequest(request, user);
        return userMapper.userDtoFromUser(userRepository.save(user));
    }

    @Override
    @Cacheable(cacheNames = "user", key = "{#userId}")
    public UserDto getById(String userId) {
        return userMapper.userDtoFromUser(userRepository.getReferenceById(userId));
    }

    @Override
    public List<UserDto> getUsersByIds(List<String> userIds) {
        return userMapper.userDtoListFromUserList(userRepository.findByIdIn(userIds));
    }
/*
    @Override
    public Aut getByUsername(String username) {
        return userMapper.userDtoListFromUserList(userRepository.findByUsername(username));
    }*/
}
