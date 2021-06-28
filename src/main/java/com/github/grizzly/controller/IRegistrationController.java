package com.github.grizzly.controller;

import com.github.grizzly.dto.UserRegDto;
import org.springframework.web.bind.annotation.PostMapping;

public interface IRegistrationController {

    @PostMapping("/register")
    String registerUser(UserRegDto regDto);
}
