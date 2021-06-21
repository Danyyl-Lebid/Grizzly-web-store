package com.github.grizzly.service.impl;

import com.github.grizzly.dto.UserAuthDto;
import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.entity.Role;
import com.github.grizzly.entity.User;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.exceptions.user.DuplicatedDataException;
import com.github.grizzly.exceptions.user.IncorrectPasswordException;
import com.github.grizzly.repository.UserRepository;
import com.github.grizzly.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Objects;

public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User create(UserRegDto regDto) {
        User user = new User(
                regDto.getFirstName(),
                regDto.getLastName(),
                regDto.getLogin(),
                passwordEncoder.encode(regDto.getPassword()),
                regDto.getEmail(),
                regDto.getPhone()
        );
        user.addRole(Role.USER);
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicatedDataException(e);
        }
    }

    @Override
    public User authorizeViaEmail(UserAuthDto authDto) {
        User user = userRepository.findByEmail(authDto.getLogin()).orElseThrow(EntityNotFoundException::new);
        return authorizeUser(user, authDto.getPassword());
    }

    @Override
    public User authorizeViaLogin(UserAuthDto authDto) {
        User user = userRepository.findByLogin(authDto.getLogin()).orElseThrow(EntityNotFoundException::new);
        return authorizeUser(user, authDto.getPassword());
    }

    @Override
    public User authorizeViaPhone(UserAuthDto authDto) {
        User user = userRepository.findByPhone(authDto.getLogin()).orElseThrow(EntityNotFoundException::new);
        return authorizeUser(user, authDto.getPassword());
    }

    @Override
    public User verify(User user) {
        user.setVerification(User.Verification.YES);
        return userRepository.save(user);
    }

    private User authorizeUser(User user, String password){
        if (!Objects.equals(
                passwordEncoder.encode(password),
                user.getPassword())) {
            throw new IncorrectPasswordException();
        }
        user.setActive(User.Active.ON);
        userRepository.save(user);
        return user;
    }

}
