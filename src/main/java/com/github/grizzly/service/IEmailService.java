package com.github.grizzly.service;

import org.springframework.stereotype.Service;


public interface IEmailService {

    void send(String emailTo, String subject, String message);
}
