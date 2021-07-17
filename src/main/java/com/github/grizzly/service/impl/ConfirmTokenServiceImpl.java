package com.github.grizzly.service.impl;

import com.github.grizzly.entity.ActiveState;
import com.github.grizzly.entity.ConfirmToken;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.repository.ConfirmTokenRepository;
import com.github.grizzly.service.IConfirmTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmTokenServiceImpl implements IConfirmTokenService {

    private final ConfirmTokenRepository tokenRepository;

    @Override
    public ConfirmToken create(ConfirmToken crt) {
        return this.tokenRepository.save(crt);
    }

    @Override
    public ConfirmToken findByToken(String token) {
        return this.tokenRepository.findByToken(token).orElseThrow(() -> new EntityNotFoundException("Entity not found in db"));
    }

    @Override
    public void delete(Long id) {
        this.tokenRepository.update(id, ActiveState.OFF);
    }
}
