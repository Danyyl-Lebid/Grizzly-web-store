package com.github.grizzly.service;

import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User findById(Long id);

    User findByLogin(String login);

    User findByEmail(String email);

    User register(UserRegDto regDto);

    void save(User user);

    User authorize(UserAuthDto authDto);

}
