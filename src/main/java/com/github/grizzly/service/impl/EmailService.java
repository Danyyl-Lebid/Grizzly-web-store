package com.github.grizzly.service.impl;

import com.github.grizzly.entity.User;
import com.github.grizzly.service.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

    public void sendVerificationEmail(User user){
        if (StringUtils.hasText(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to GRIZZLY. Please, visit next link: http://localhost:8080/activate/%s",
                    user.getFirstName(),
                    user.getActivationCode()
            );
            this.send(user.getEmail(), "Activation code", message);
        }

    }
}
