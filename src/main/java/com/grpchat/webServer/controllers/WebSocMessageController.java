package com.grpchat.webServer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.services.kafka.KafkaProducerService;
import com.grpchat.webServer.model.MessageModel;
import com.grpchat.webServer.entity.MessageEntity;
import com.grpchat.webServer.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class WebSocMessageController {

    private final MessageRepository messageRepository;
    private final KafkaProducerService kafkaProducerService;
    private final ObjectMapper objectMapper;

    @Autowired
    public WebSocMessageController(MessageRepository messageRepository, KafkaProducerService kafkaProducerService) {
        this.messageRepository = messageRepository;
        this.kafkaProducerService = kafkaProducerService;
        this.objectMapper = new ObjectMapper(); // for JSON serialization
    }

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload MessageModel chatMessage) throws JsonProcessingException {
        MessageEntity messageEntity = new MessageEntity(
                chatMessage.getSender(),
                chatMessage.getContent(),
                chatMessage.getRoom(),
                LocalDateTime.now(),
                chatMessage.getIsFile(),
                chatMessage.getFileId(),
                chatMessage.getReplyOn()
        );
        messageRepository.save(messageEntity);

        // to String
        String jsonMessage = objectMapper.writeValueAsString(chatMessage);
        // Publish to Kafka
        kafkaProducerService.sendToTopic(jsonMessage);
    }
}
