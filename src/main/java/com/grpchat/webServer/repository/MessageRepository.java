package com.grpchat.webServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grpchat.webServer.entity.MessageEntity;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByRoomIdOrderByTimestampAsc(String roomId);
}