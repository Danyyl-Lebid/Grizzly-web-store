package com.github.grizzly.dto;

import com.github.grizzly.utils.annotations.*;
import com.github.grizzly.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;

@Data
public class UserRegDto {

    @NotEmpty(message = "Firstname is required")
    private String firstName;

    @NotEmpty(message = "Lastname is required")
    private String lastName;

    @ValidLogin
    @NotEmpty(message = "Login is required")
    private String login;

    @NotEmpty(message = "Password is required")
    private String password;

    @ValidEmail(message = "Should have email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone is required")
    private String phone;

    private String activationCode;
}
