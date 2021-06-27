package com.github.grizzly.controller;

import com.github.grizzly.dto.UserAuthDto;
import org.springframework.web.bind.annotation.PostMapping;

public interface IAuthorizationController {

    @PostMapping("/auth")
    AuthResponse authorize(UserAuthDto authDto);
}
