package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IRegistrationController;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController implements IRegistrationController {

    private final IUserService userService;

    @Autowired
    public RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public HttpStatus registerUser(@RequestBody UserRegDto userRegDto) {
        userService.create(userRegDto);
        return HttpStatus.OK;
    }
}
