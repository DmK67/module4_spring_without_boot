package ru.practicum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    UserDto saveNewUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

}
