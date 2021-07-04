package com.github.grizzly.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
@Component
public class PreAuthJwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";

    private final TokenJwtProvider tokenJwtProvider;

    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public PreAuthJwtFilter(TokenJwtProvider tokenJwtProvider, CustomUserDetailsService customUserDetailsService) {
        this.tokenJwtProvider = tokenJwtProvider;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var token = getTokenFromRequest((HttpServletRequest) request);
        if (token != null && tokenJwtProvider.validateToken(token)) {
            var id = this.tokenJwtProvider.getUserIdFromToken(token);
            UserDetails user = this.customUserDetailsService.loadUserById(id);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            request.setAttribute("userId",id);
        }
        chain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
