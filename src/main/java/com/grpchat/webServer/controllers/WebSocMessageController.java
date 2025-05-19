package com.grpchat.webServer.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import com.grpchat.webServer.model.ChatMessageModel;

@Controller
public class WebSocMessageController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocMessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageModel chatMessage) {
        messagingTemplate.convertAndSend("/chat/" + chatMessage.getRoom(), chatMessage);
    }
}
