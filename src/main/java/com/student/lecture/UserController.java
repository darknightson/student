package com.student.lecture;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService = new UserService();

    @PostMapping("/user/save")
    public void save() {
        userService.save();
    }
}
