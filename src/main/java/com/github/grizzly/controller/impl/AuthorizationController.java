package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.AuthResponse;
import com.github.grizzly.controller.IAuthorizationController;
import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.entity.User;
import com.github.grizzly.security.jwt.JwtProvider;
import com.github.grizzly.service.IUserService;
import com.github.grizzly.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationController implements IAuthorizationController {

    private final IUserService userService;

    private final JwtProvider jwtProvider;

    @Autowired
    public AuthorizationController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public AuthResponse authorize(@RequestBody UserAuthDto authDto) {
        User user = userService.findByLoginAndPassword(authDto.getLogin(), authDto.getPassword());
        String token = jwtProvider.generateToken(user);
        return new AuthResponse(token);
    }
}
