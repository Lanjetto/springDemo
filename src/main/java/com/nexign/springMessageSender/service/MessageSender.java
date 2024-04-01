package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.model.DestinationInterface;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MessageSender {

    private DestinationInterface destination;
    private MessageDAO messageDAO;

    @Autowired
    public MessageSender(DestinationInterface destination, MessageDAO messageDAO) {
        this.destination = destination;
        this.messageDAO = messageDAO;
    }
    //IoC - inversion of control

    public void send(Message message) {
        messageDAO.send(message.getText());
        System.out.println("Meesage " + message.getText() + " sended to " + destination.getCity());
    }

    public void send(Message...messages) {
        Arrays.stream(messages)
                .peek(message -> System.out.println(message.getText() + " sended to " + destination.getCity()))
                .forEach(message -> messageDAO.send(message.getText()));
    }
}
