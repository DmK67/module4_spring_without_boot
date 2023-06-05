package ru.practicum.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    User saveNewUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
