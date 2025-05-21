package com.grpchat.webServer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.grpchat.webServer.model.ChatMessageModel;
import com.grpchat.webServer.entity.Message;
import com.grpchat.webServer.repository.MessageRepository;

import java.time.LocalDateTime;

@Controller
public class WebSocMessageController {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;

    @Autowired
    public WebSocMessageController(SimpMessagingTemplate messagingTemplate,
                                   MessageRepository messageRepository) {
        this.messagingTemplate = messagingTemplate;
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageModel chatMessage) {

        // Convert ChatMessageModel to JPA entity
        Message messageEntity = new Message();
        messageEntity.setSenderId(chatMessage.getSender());
        messageEntity.setContent(chatMessage.getContent());
        messageEntity.setRoomId(chatMessage.getRoom());
        messageEntity.setTimestamp(LocalDateTime.now());

        // Save to Postgres SQL
        messageRepository.save(messageEntity);

        // Broadcast to subscribers in the room
        messagingTemplate.convertAndSend("/chat/room/" + chatMessage.getRoom(), chatMessage);
    }
}
