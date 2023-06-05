package ru.practicum.user;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);

}
