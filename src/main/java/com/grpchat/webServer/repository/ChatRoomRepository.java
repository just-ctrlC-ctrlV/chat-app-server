package com.grpchat.webServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grpchat.webServer.entity.ChatRoomEntity;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {}