package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.DestinationInterface;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageDAO;
import com.nexign.springMessageSender.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class MessageSender {

    private DestinationInterface destination;
    private MessageRepository messageRepository;

    @Autowired
    public MessageSender(DestinationInterface destination, MessageRepository messageRepository) {
        this.destination = destination;
        this.messageRepository = messageRepository;
    }
    //IoC - inversion of control

    public void send(Message message) {
        messageRepository.save(message);
        System.out.println("Meesage " + message.getText() + " sended to " + destination.getCity());
    }

//    public void send(Message...messages) {
//        Arrays.stream(messages)
//                .peek(message -> System.out.println(message.getText() + " sended to " + destination.getCity()))
//                .forEach(message -> messageRepository.send(message.getText()));
//    }


    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow();

    }
}
