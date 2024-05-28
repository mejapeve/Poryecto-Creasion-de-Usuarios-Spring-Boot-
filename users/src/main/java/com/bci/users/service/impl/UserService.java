package com.bci.users.service.impl;

import com.bci.users.dto.PhoneDto;
import com.bci.users.dto.UserDto;
import com.bci.users.dto.UserResponseDto;
import com.bci.users.entity.Phone;
import com.bci.users.entity.User;
import com.bci.users.exception.UserAlreadyExists;
import com.bci.users.mapper.PhoneMapper;
import com.bci.users.mapper.UserMapper;
import com.bci.users.service.IUserService;
import com.bci.users.repository.PhoneRepository;
import com.bci.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserService implements IUserService {

    final UserRepository userRepository;
    final PhoneRepository phoneRepository;

    @Override
    public UserResponseDto createUser(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByEmail(userDto.getEmail());
        if(existingUser.isPresent()){
            throw new UserAlreadyExists("The email "+userDto.getEmail()+" it already exists");
        }

        User user = UserMapper.mapUserDtoToUser(userDto);
        user.setCreated_at(LocalDateTime.now());
        user.setModified_at(LocalDateTime.now());
        user.setLast_login(LocalDateTime.now());
        user.setToken(UUID.randomUUID().toString());
        user.setActive(true);

        User saveUser = userRepository.save(user);


        if (userDto.getPhones() != null) {
            for (PhoneDto phoneDto : userDto.getPhones()) {
                Phone phone = PhoneMapper.mapPhoneDtoToPhone(phoneDto);
                phone.setUser(saveUser);
                phoneRepository.save(phone);            }
        }

        UserResponseDto userResponseDto =UserMapper.mapUserToUserResponseDto(saveUser);

        return userResponseDto;

    }
}
