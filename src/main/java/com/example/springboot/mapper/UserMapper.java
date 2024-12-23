package com.example.springboot.mapper;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;

public class UserMapper {

    // convert User JPA Entity into UserDTO
    public static UserDto mapToUserDto(User user) {

        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );

        return userDto;
    }

    // convert UserDto into User JAP Entity
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

        return user;
    }
}
