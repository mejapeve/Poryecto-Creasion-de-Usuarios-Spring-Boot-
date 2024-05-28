package com.bci.users.service;

import com.bci.users.dto.UserDto;
import com.bci.users.dto.UserResponseDto;

public interface IUserService {
    UserResponseDto createUser(UserDto userDto);


}
