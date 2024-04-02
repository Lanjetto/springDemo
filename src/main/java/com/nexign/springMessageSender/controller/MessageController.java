package com.nexign.springMessageSender.controller;

import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private MessageSender messageSender;
    @Autowired
    public MessageController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping("/message")
    public ResponseEntity<Message> getMessageById(@RequestParam(name = "id") Long id) {
        Message message = messageSender.getMessageById(id);
        return ResponseEntity.ok(message);
    }
}
