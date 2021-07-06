package com.github.grizzly.security;


import com.github.grizzly.entity.User;
import com.github.grizzly.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username);
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Long id) {
        return UserPrincipal.create(this.userService.findById(id)) ;
    }
}
