package com.github.grizzly.service;

import org.springframework.stereotype.Service;


public interface IEmailService {

    String sendMessageToEmail(String toAddress,String subject,String text);
}
