package io.github.abhinav99ash29.service;

import io.github.abhinav99ash29.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.destination-mail}")
    String destinationMail;

    @Value("${spring.mail.from-mail}")
    String fromMail;

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Message message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setTo(destinationMail);
        simpleMailMessage.setSubject("Message from "+message.getName());
        simpleMailMessage.setText(message.getMessage()+"\n\n"+"Email: "+message.getEmail());
        emailSender.send(simpleMailMessage);
    }

}
