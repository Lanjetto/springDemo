package com.nexign.springMessageSender.model;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private Long userId = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
