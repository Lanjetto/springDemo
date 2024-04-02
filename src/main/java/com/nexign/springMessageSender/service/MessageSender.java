package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.entities.MessageEntity;
import com.nexign.springMessageSender.model.CurrentUser;
import com.nexign.springMessageSender.model.DestinationInterface;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private DestinationInterface destination;
    private MessageRepository messageRepository;

    private CurrentUser currentUser;

    @Autowired
    public MessageSender(DestinationInterface destination, MessageRepository messageRepository, CurrentUser currentUser) {
        this.destination = destination;
        this.messageRepository = messageRepository;
        this.currentUser = currentUser;
    }
    //IoC - inversion of control

//    public void send(Message message) {
//        messageRepository.save(message);
//        System.out.println("Meesage " + message.getText() + " sended to " + destination.getCity());
//    }

    public void send(String message, Long to) {
        Long userId = currentUser.getUserId();
        MessageEntity messageEntity = new MessageEntity(message, userId, to);
        messageRepository.save(messageEntity);

    }

//    public void send(Message...messages) {
//        Arrays.stream(messages)
//                .peek(message -> System.out.println(message.getText() + " sended to " + destination.getCity()))
//                .forEach(message -> messageRepository.send(message.getText()));
//    }


    public MessageEntity getMessageById(Long id) {
        return messageRepository.findById(id).orElseThrow();

    }
}
