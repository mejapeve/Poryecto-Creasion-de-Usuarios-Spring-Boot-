package com.bci.users.mapper;


import com.bci.users.dto.UserDto;
import com.bci.users.dto.UserResponseDto;
import com.bci.users.entity.User;


public class UserMapper {


    public static User mapUserDtoToUser (UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public static UserResponseDto mapUserToUserResponseDto (User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUsername(user.getEmail());
        userResponseDto.setId(user.getId());
        userResponseDto.setCreated_at(user.getCreated_at());
        userResponseDto.setModified_at(user.getModified_at());
        userResponseDto.setLast_login(user.getLast_login());
        userResponseDto.setToken(user.getToken());
        userResponseDto.setActive(user.isActive());

        return userResponseDto;
    }



}
