package com.branko.midlevel.codejudge.mapper;

import com.branko.midlevel.codejudge.dto.other.UserDto;
import com.branko.midlevel.codejudge.dto.request.CreateUserRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateContestRequest;
import com.branko.midlevel.codejudge.dto.request.UpdateUserRequest;
import com.branko.midlevel.codejudge.repository.entity.Contest;
import com.branko.midlevel.codejudge.repository.entity.User;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userDtoFromUser(User user);

    User userFromUserDto(UserDto userDto);

    User userFromCreateUserRequest(CreateUserRequest user);

    List<UserDto> userDtoListFromUserList(List<User> users);

    void updateUserFromRequest(UpdateUserRequest request, @MappingTarget User user);

    @Condition
    default boolean isNotBlank(String value) {
        return value != null && !value.isBlank();
    }
}
