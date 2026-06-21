package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.CreateUserRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.repository.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userDtoFromMapUser(User user);

    User userFromMapCreateUserRequest(CreateUserRequest user);

    //User userFromMapUpdateUserRequest(UpdateUserRequest userUpdate, User user);
}
