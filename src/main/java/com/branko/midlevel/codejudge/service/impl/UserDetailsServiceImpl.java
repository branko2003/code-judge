package com.branko.midlevel.codejudge.service.impl;

import com.branko.midlevel.codejudge.dto.other.UserAuth;
import com.branko.midlevel.codejudge.helper.MessageUtil;
import com.branko.midlevel.codejudge.mapper.UserMapper;
import com.branko.midlevel.codejudge.repository.UserRepository;
import com.branko.midlevel.codejudge.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final MessageUtil messageUtil;
    private final UserMapper userMapper;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userMapper.userAuthFromUser(userRepository.findByUsername(username));
        if (user == null) {
            throw new UsernameNotFoundException(messageUtil.get("user.notfound"));
        }
        return new CustomUserDetails(user);
    }
}
