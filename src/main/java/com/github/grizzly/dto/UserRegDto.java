package com.github.grizzly.dto;

import com.github.grizzly.annotations.*;
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
public class UserRegDto implements UserDetails {

//    @ValidName
    @NotEmpty(message = "Firstname is required")
    private String firstName;

//    @ValidName
    @NotEmpty(message = "Lastname is required")
    private String lastName;

    @ValidLogin
    @NotEmpty(message = "Login is required")
    private String login;

//    @ValidPassword
    @NotEmpty(message = "Password is required")
    private String password;

    @ValidEmail(message = "Should have email format")
    @NotBlank(message = "Email is required")
    private String email;

//    @ValidPhone
    @NotEmpty(message = "Phone is required")
    private String phone;

    private String activationCode;

    public static UserRegDto fromUserEntityToCustomUserDetails(User user) {
        UserRegDto c = new UserRegDto();
        c.login = user.getLogin();
        c.password = user.getPassword();
        c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRoles().toString()));
        return c;
    }

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
