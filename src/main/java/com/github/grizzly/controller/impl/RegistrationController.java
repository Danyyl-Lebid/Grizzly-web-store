package com.github.grizzly.controller.impl;

import com.github.grizzly.controller.IRegistrationController;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.service.IEmailService;
import com.github.grizzly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController implements IRegistrationController {

    private final IUserService userService;

    private final IEmailService IEmailService;

    @Autowired
    public RegistrationController(IUserService userService, IEmailService IEmailService) {
        this.userService = userService;
        this.IEmailService = IEmailService;
    }

    @Override
    public HttpStatus registerUser(@RequestBody UserRegDto userRegDto) {
        IEmailService.sendMessageToEmail(userRegDto.getEmail(),"Verification user","\"Hello, %s! \\n\" +\n" +
                "                            \"Welcome to Sweater. Please, visit next link: http://localhost:8080/activate/%s\"");
        userService.create(userRegDto);
        return HttpStatus.OK;
    }
}
