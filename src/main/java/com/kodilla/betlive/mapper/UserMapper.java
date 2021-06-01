package com.kodilla.betlive.mapper;

import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.domain.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setBalance(userDto.getBalance());
        user.setUserName(userDto.getUserName());
        return user;
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getBalance()
        );
    }
}
