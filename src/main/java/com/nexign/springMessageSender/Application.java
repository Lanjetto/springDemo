package com.nexign.springMessageSender;

import com.nexign.springMessageSender.config.BeanConfig;
import com.nexign.springMessageSender.model.Message;
import com.nexign.springMessageSender.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    ;
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class);

        List<Message> messages = new ArrayList<>();
        MessageSender messageSender = context.getBean(MessageSender.class);
        for (int i = 0; i < 5; i++) {
            messages.add(context.getBean(Message.class));
        }
        messages.forEach(messageSender::send);


    }
}
