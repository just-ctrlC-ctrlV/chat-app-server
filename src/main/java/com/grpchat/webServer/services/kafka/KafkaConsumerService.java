package com.grpchat.webServer.services.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.model.MessageModel;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final SimpMessagingTemplate messagingTemplate;
    private final ObjectMapper objectMapper;

    public KafkaConsumerService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "chat-messages", groupId = "#{T(java.util.UUID).randomUUID().toString()}")
    public void listen(String message) {
        try {
            // Parse the JSON message into a ChatMessageModel
            MessageModel chatMessage = objectMapper.readValue(message, MessageModel.class);

            // Broadcast to clients subscribed to the specific room
            String destination = "/chat/room/" + chatMessage.getRoom();
            messagingTemplate.convertAndSend(destination, chatMessage);

        } catch (Exception e) {
            // Optional: log the error or handle it
            System.err.println("Failed to parse or send message: " + e.getMessage());
        }
    }
}
