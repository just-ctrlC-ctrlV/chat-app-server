package com.grpchat.webServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.entity.ChatRoomEntity;
import com.grpchat.webServer.model.ChatRoomModel;
import com.grpchat.webServer.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.objectMapper = new ObjectMapper();
    }
    public List<ChatRoomModel> getAllChatRooms(){
       List<ChatRoomEntity> data=chatRoomRepository.findAll();
        return data.stream().map(chatRoomEntity -> objectMapper.convertValue(chatRoomEntity, ChatRoomModel.class)).collect(Collectors.toList());
    }
    public ChatRoomModel getChatRoomById(Long roomId){
        return objectMapper.convertValue(chatRoomRepository.findByRoomId(roomId).getFirst(), ChatRoomModel.class);
    }
    public ChatRoomModel save(ChatRoomModel chatRoom){
        return objectMapper.convertValue(chatRoomRepository.save(objectMapper.convertValue(chatRoom, ChatRoomEntity.class)),ChatRoomModel.class);
    }
    public List<ChatRoomModel> getChatRoomsOfUser(List<Long> roomIds){
        return chatRoomRepository.findByRoomIdIn(roomIds).stream().map(chatRoomEntity -> objectMapper.convertValue(chatRoomEntity, ChatRoomModel.class)).collect(Collectors.toList());
    }
}
