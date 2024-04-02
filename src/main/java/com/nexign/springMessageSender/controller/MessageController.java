package com.nexign.springMessageSender.controller;

import com.nexign.springMessageSender.entities.MessageEntity;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    private MessageSender messageSender;
    @Autowired
    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/message")
    public ResponseEntity<Message> getMessageById(@RequestParam(name = "id") Long id) {
        MessageEntity messageEntity = messageSender.getMessageById(id);
        Message message = new Message(messageEntity.getMessageText());
        return ResponseEntity.ok(message);
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        messageSender.send(message.getText(), message.getTo());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
