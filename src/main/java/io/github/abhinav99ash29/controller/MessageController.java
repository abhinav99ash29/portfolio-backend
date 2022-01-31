package io.github.abhinav99ash29.controller;

import io.github.abhinav99ash29.domain.Message;
import io.github.abhinav99ash29.service.EmailService;
import io.github.abhinav99ash29.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    EmailService emailService;

    @PostMapping
    private Message saveMessage(@RequestBody Message message) {
        try {
            Message writtenMessage = messageService.saveMessage(message);
            emailService.sendSimpleMessage(writtenMessage);
            return writtenMessage;
        } catch (Exception ex) {
            log.error("Error during persisting and sending an email: ", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
