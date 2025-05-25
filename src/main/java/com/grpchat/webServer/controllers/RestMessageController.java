package com.grpchat.webServer.controllers;

import com.grpchat.webServer.model.FileModel;
import com.grpchat.webServer.model.MessageModel;
import com.grpchat.webServer.services.ChatRoomService;
import com.grpchat.webServer.services.FileUploadService;
import com.grpchat.webServer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import com.grpchat.webServer.model.ChatRoomModel;

import java.util.List;

@RestController
public class RestMessageController {

    private final ChatRoomService chatRoomService;
    private final MessageService messageService;
    private final FileUploadService fileUploadService;


    @Autowired
    public RestMessageController(ChatRoomService chatRoomService, MessageService messageService, FileUploadService fileUploadService) {
        this.chatRoomService = chatRoomService;
        this.messageService = messageService;
        this.fileUploadService = fileUploadService;
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

    @PostMapping("/chat/room/{roomId}/file")
    public void fileUpload( @Payload FileModel file) {
        fileUploadService.saveFile(file);
    }

}
