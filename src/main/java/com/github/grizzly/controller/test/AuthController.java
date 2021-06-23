package com.github.grizzly.controller.test;

import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.entity.User;
import com.github.grizzly.security.jwt.JwtProvider;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    private UserService userService;

    private JwtProvider jwtProvider;

    @Autowired
    public AuthController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserRegDto userRegDto) {
        userService.create(userRegDto);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody UserAuthDto authDto) {
        User user = userService.findByLoginAndPassword(authDto.getLogin(), authDto.getPassword());
        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token);
    }
}