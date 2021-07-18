package com.github.grizzly.controller.impl;

import com.github.grizzly.dto.AuthResponse;
import com.github.grizzly.controller.IAuthorizationController;
import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.entity.User;
import com.github.grizzly.security.TokenJwtProvider;
import com.github.grizzly.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
public class AuthorizationController implements IAuthorizationController {

    private final IUserService userService;

    private final TokenJwtProvider tokenJwtProvider;

    @Override
    public AuthResponse authorize(@RequestBody @Valid UserAuthDto authDto) {
        User user = userService.authorize(authDto.getLogin(), authDto.getPassword());
        String token = tokenJwtProvider.generateToken(user);
        return new AuthResponse(token);
    }
}
