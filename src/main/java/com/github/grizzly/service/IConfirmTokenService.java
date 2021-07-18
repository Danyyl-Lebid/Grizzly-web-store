package com.github.grizzly.service;

import com.github.grizzly.entity.ConfirmToken;

public interface IConfirmTokenService {

    ConfirmToken create(ConfirmToken crt);

    ConfirmToken findByToken(String token);

    void delete(Long id);
}
