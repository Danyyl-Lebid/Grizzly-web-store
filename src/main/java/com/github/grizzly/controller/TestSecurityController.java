package com.github.grizzly.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiImplicitParams(
        @ApiImplicitParam(
                name = "Authorization",
                value = "Access Token",
                required = true,
                paramType = "header",
                example = "Bearer access_token"
        )
)
public class TestSecurityController {
    @Secured("ROLE_ADMIN")
    @GetMapping("/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }


    @Secured("ROLE_USER")
    @GetMapping("/user/get")
    public String getUser() {
        return "Hi user";
    }
}