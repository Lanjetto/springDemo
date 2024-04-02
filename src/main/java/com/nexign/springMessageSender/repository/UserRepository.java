package com.nexign.springMessageSender.repository;

import com.nexign.springMessageSender.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
