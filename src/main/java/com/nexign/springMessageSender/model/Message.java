package com.nexign.springMessageSender.model;

import jakarta.persistence.*;

//@Entity
//@Table(name = "messages")
public class Message {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long to;
//    @Column(name = "message_body")
    private String text;

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
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
    }
}
