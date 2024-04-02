package com.nexign.springMessageSender.controller;


import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    private MessageSender messageSender;

    @Autowired
    public FormController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @GetMapping
    public String getForm() {
        return "messageForm";
    }
    @PostMapping("/submit-message")
    public String submitMessage(@RequestParam("message") String message,
                                Model model) {
        Message newMessage = new Message(message);
        messageSender.send(newMessage);
        model.addAttribute("notification", "Message sent successfully!");
        return "messageForm";
    }

}
