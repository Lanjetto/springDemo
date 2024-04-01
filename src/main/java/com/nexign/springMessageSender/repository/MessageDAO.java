package com.nexign.springMessageSender.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MessageDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("CREATE TABLE messages (id INT AUTO_INCREMENT PRIMARY KEY, text VARCHAR(255))");
    }

    public void send(String text) {
        jdbcTemplate.update("INSERT INTO messages (text) VALUES (?)", text);
    }
}
