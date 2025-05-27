package com.grpchat.webServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.entity.UserEntity;
import com.grpchat.webServer.model.UserModel;
import com.grpchat.webServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.objectMapper = new ObjectMapper();
    }
    public UserModel saveUser(UserModel user){
        return objectMapper.convertValue(userRepository.save(objectMapper.convertValue(user, UserEntity.class)),UserModel.class);
    }
    public UserModel getUserByEmail(String userEmail){
        return objectMapper.convertValue(userRepository.findByEmail(userEmail).getFirst(), UserModel.class);
    }
    public void addUserToRoom(String email, String roomId) {
        UserEntity user = userRepository.findByEmail(email).getFirst();

        List<String> chatRooms = user.getSubscribedToChatRooms();

        if (!chatRooms.contains(roomId)) {
            chatRooms.add(roomId);
            user.setSubscribedToChatRooms(chatRooms);
            userRepository.save(user);
        }
    }

}
