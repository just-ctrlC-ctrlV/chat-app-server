package com.grpchat.webServer.controllers;

import com.grpchat.webServer.model.ChatRoomModel;
import com.grpchat.webServer.model.ListOfRoomIds;
import com.grpchat.webServer.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    @Autowired
    public ChatRoomController(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }
    @GetMapping("/chat/room/all")
    public List<ChatRoomModel> getChatServers() {
        return chatRoomService.getAllChatRooms();
    }

    @GetMapping("/chat/room/{roomId}")
    public ChatRoomModel getRoomById(@PathVariable Long roomId) {
        return chatRoomService.getChatRoomById(roomId);
    }

    @PostMapping("/chat/room/user/all")
    public List<ChatRoomModel> getChatRoomsOfUser(@RequestBody ListOfRoomIds roomIds) {
    return chatRoomService.getChatRoomsOfUser(roomIds.getListOfRoomIds());
    }

    @PostMapping("/chat/room/create")
    public ChatRoomModel createRoom(@RequestBody ChatRoomModel chatRoom) {
        return chatRoomService.save(chatRoom);
    }


}
