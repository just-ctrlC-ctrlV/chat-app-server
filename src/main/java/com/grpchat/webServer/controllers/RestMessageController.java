package com.grpchat.webServer.controllers;

import com.grpchat.webServer.model.MessageModel;
import com.grpchat.webServer.services.ChatRoomService;
import com.grpchat.webServer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.grpchat.webServer.model.ChatRoomModel;

import java.util.List;

@RestController
public class RestMessageController {

    private final ChatRoomService chatRoomService;
    private final MessageService messageService;


    @Autowired
    public RestMessageController(ChatRoomService chatRoomService, MessageService messageService) {
        this.chatRoomService = chatRoomService;
        this.messageService = messageService;
    }

    @GetMapping("/rooms")
    public List<ChatRoomModel> getChatServers() {
        return chatRoomService.getAllChatRooms();
    }

    @GetMapping("/message/room/{roomId}")
    public List<MessageModel> getInitialMessages(@PathVariable String roomId) {
        return messageService.getInitialMessages(roomId);

    }
    @GetMapping("/chat/room/{roomId}")
    public ChatRoomModel getRoomById(@PathVariable String roomId) {
        return chatRoomService.getChatRoomById(Long.parseLong(roomId));
    }

    @PostMapping("/chat/room/{roomId}")
    public String sendMessage(@PathVariable String roomId) {
    return "Message sent to room "+roomId;
    }

}
