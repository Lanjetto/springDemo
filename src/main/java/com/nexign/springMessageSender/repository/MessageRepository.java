package com.nexign.springMessageSender.repository;

import com.nexign.springMessageSender.entities.MessageEntity;
import com.nexign.springMessageSender.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
