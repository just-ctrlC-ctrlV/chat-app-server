package com.grpchat.webServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.entity.MessageEntity;
import com.grpchat.webServer.model.MessageModel;
import com.grpchat.webServer.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public MessageService(MessageRepository messageRepository, ObjectMapper objectMapper) {
        this.messageRepository = messageRepository;
        this.objectMapper = objectMapper;
    }
    public List<MessageModel> getInitialMessages(String roomId){
        List<MessageEntity> data= messageRepository.findByRoomId(roomId);
        System.out.println(data.getFirst().getTimestamp());
        return data.stream().map(message-> objectMapper.convertValue(message,MessageModel.class)).collect(Collectors.toList());
    }
}
