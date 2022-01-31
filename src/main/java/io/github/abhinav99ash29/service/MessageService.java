package io.github.abhinav99ash29.service;

import io.github.abhinav99ash29.domain.Message;
import io.github.abhinav99ash29.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message saveMessage(Message message) {
       return messageRepository.save(message);
    }

}
