package com.github.grizzly.controller.impl;

import com.github.grizzly.dto.ForgotPassDto;
import com.github.grizzly.entity.ConfirmToken;
import com.github.grizzly.entity.User;
import com.github.grizzly.exceptions.InvalidTokenException;
import com.github.grizzly.exceptions.WrongUserEmail;
import com.github.grizzly.service.IConfirmTokenService;
import com.github.grizzly.service.IEmailService;
import com.github.grizzly.service.impl.ForgotPasswordService;
import com.github.grizzly.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@ApiImplicitParams(
        @ApiImplicitParam(
                name = "Authorization",
                value = "Access Token",
                required = true,
                paramType = "header",
                example = "Bearer access_token"
        )
)
public class ForgotPasswordController {

    private final UserService userService;

    private final ForgotPasswordService passwordService;

    private final IEmailService emailService;

    private final PasswordEncoder passwordEncoder;

    private final IConfirmTokenService confirmTokenService;

    @PostMapping("/forgot")
    @ResponseStatus(HttpStatus.CREATED)
    public void submitForgotPassword(@Valid @RequestBody ForgotPassDto payload) {
        User user = this.passwordService.findByEmail(payload.getEmail());
        if (StringUtils.hasText(user.getEmail())) {
            String token = UUID.randomUUID().toString();
            ConfirmToken ct = new ConfirmToken(user, token, this.passwordEncoder.encode(payload.getConfirmPassword()));
            var pattern = String.format(
                    "Hello, %s! \n" +
                            "Welcome to GRIZZLY. Please, visit next link: http://localhost:8080/password?token=%s",
                    user.getFirstName(),
                    token);
            this.emailService.send(
                    user.getEmail(), "Password change", pattern);
            this.confirmTokenService.create(ct);
        } else {
            throw new WrongUserEmail();
        }
    }

    @GetMapping("/password")
    @ResponseStatus(HttpStatus.OK)
    public void changePassword(@RequestParam("token") String token) {
        ConfirmToken ct = this.confirmTokenService.findByToken(token);
        if (ct.getToken().equals(token)) {
            User user = ct.getUser();
            this.userService.updateUser(user.newPass(ct.getNewPass()));
        } else {
            throw new InvalidTokenException();
        }
    }
}
