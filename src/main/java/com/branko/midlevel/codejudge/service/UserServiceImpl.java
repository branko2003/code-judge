package com.branko.midlevel.codejudge.service;

import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.UserRepository;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.User;
import lombok.RequiredArgsConstructor;
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
    public UserDto updateUser(String userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException(messageUtil.get("contest.notfound")));
        userMapper.updateUserFromRequest(request, user);
        return userMapper.userDtoFromUser(userRepository.save(user));
    }

    @Override
    public UserDto getById(String userId) {
        return userMapper.userDtoFromUser(userRepository.getReferenceById(userId));
    }

    @Override
    public List<UserDto> getUsersByIds(List<String> userIds) {
        return userMapper.userDtoListFromUserList(userRepository.findByIdIn(userIds));
    }
}
