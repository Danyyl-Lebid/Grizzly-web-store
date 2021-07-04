package com.github.grizzly.controller;

import com.github.grizzly.dto.UserRegDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;

public interface IRegistrationController {

    @PostMapping("/register")
    HttpStatus registerUser(UserRegDto regDto);
}
