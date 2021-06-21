package com.github.grizzly.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserRegDto {

    @NotEmpty(message = "Firstname is required")
    private String firstName;

    @NotEmpty(message = "Lastname is required")
    private String lastName;

    @NotEmpty(message = "Login is required")
    private String login;

    @NotEmpty(message = "Password is required")
    @Size(min = 6)
    private String password;

    @Email(message = "Should have email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotEmpty(message = "Phone is required")
    private String phone;

}
