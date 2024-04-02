package com.nexign.springMessageSender.service;

import com.nexign.springMessageSender.entities.MessageEntity;
import com.nexign.springMessageSender.model.CurrentUser;
import com.nexign.springMessageSender.model.DestinationInterface;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.repository.MessageRepository;
import com.nexign.springMessageSender.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageSender {

    private DestinationInterface destination;
    private MessageRepository messageRepository;
    private CurrentUser currentUser;
    private UserRepository userRepository;

    @Autowired
    public MessageSender(DestinationInterface destination, MessageRepository messageRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.destination = destination;
        this.messageRepository = messageRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
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

    public List<Message> getUserMessages() {
        List<MessageEntity> messageEntities =
                messageRepository.findByReceiverId(currentUser.getUserId());
        return messageEntities.stream()
                .map(entity -> new Message(entity.getMessageText()))
                .collect(Collectors.toList());

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
