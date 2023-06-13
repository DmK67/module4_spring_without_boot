package ru.practicum.user;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto userDto);

}
