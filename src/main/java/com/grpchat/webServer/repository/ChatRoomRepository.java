package com.grpchat.webServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grpchat.webServer.entity.ChatRoomEntity;

import java.util.Collection;
import java.util.List;

public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Long> {
    List<ChatRoomEntity> findByRoomIdIn(Collection<Long> roomIds);

    List<ChatRoomEntity> findByRoomId(Long roomId);
}