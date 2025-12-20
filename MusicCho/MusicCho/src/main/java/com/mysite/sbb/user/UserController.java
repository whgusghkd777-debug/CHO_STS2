package com.mysite.sbb.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/create")
    public String createUser(@RequestParam String username,
                             @RequestParam String password1,
                             @RequestParam String email) {
        userService.create(username, password1, email, "USER");
        return "redirect:/";
    }
}