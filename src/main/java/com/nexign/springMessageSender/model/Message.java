package com.nexign.springMessageSender.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class Message {
    private String text;
    @Value("${random.strings}")
    private String[] randomStrings;


    @PostConstruct
    public void init() {
        Random random = new Random();
        int index = random.nextInt(randomStrings.length);
        this.text = randomStrings[index];
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(String text) {
        this.text = text;
    }

    public Message() {
        this.text = "Hello";
    }
}
