package com.github.grizzly.service.impl;

import com.github.grizzly.dto.UserRegDto;
import com.github.grizzly.entity.Role;
import com.github.grizzly.entity.User;
import com.github.grizzly.exceptions.DuplicatedDataException;
import com.github.grizzly.exceptions.EntityNotFoundException;
import com.github.grizzly.exceptions.user.IncorrectPasswordException;
import com.github.grizzly.repository.UserRepository;
import com.github.grizzly.service.IEmailService;
import com.github.grizzly.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final IEmailService emailService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User create(UserRegDto regDto) {
        checkPresence(regDto);
        User user = new User(
                regDto.getFirstName(),
                regDto.getLastName(),
                regDto.getLogin(),
                passwordEncoder.encode(regDto.getPassword()),
                regDto.getEmail(),
                regDto.getPhone()
        );
        user.addRole(Role.USER);
        user.setActivationCode(UUID.randomUUID().toString());
        emailService.sendVerificationEmail(user);
        return userRepository.save(user);
    }

    private void checkPresence(UserRegDto regDto) {
        boolean loginConflict = userRepository.existsByLogin(regDto.getLogin());
        boolean emailConflict = userRepository.existsByEmail(regDto.getEmail());
        boolean phoneConflict = userRepository.existsByPhone(regDto.getPhone());
        if (loginConflict || emailConflict || phoneConflict) {
            String message = String.format(
                    "loginConflict = %b, emailConflict = %b, phoneConflict = %b",
                    loginConflict, emailConflict, phoneConflict);
            throw new DuplicatedDataException(message);
        }
    }

    @Override
    public User authorize(String login, String password) {
        User user = userRepository.findByEmailOrLoginOrPhone(login, login, login).orElseThrow(EntityNotFoundException::new);
        if (passwordEncoder.matches(password, user.getPassword())) {
            if (user.getVerification().equals(User.Verification.YES)) {
                user.setActive(User.Active.ON);
                userRepository.save(user);
                return user;
            }
        }throw new IncorrectPasswordException();
    }

    @Override
    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setVerification(User.Verification.YES);
        user.setActivationCode(null);
        userRepository.save(user);

        return true;
    }

}
