package com.nexign.springMessageSender;

import com.nexign.springMessageSender.config.BeanConfig;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);

        List<Message> messages = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            messages.add(context.getBean(Message.class));
        }
        messages.forEach(messageSender::send);


    }
}
