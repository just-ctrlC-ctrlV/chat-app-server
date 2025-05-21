package com.grpchat.webServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grpchat.webServer.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {}