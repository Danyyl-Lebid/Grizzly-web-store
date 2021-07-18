package com.github.grizzly.service;

import com.github.grizzly.entity.User;
import org.springframework.stereotype.Service;


public interface IEmailService {

    void send(String emailTo, String subject, String message);

    void sendVerificationEmail(User user);
}
