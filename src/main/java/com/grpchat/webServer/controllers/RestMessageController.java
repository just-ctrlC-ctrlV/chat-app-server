package com.grpchat.webServer.controllers;

import com.grpchat.webServer.model.FileModel;
import com.grpchat.webServer.model.MessageModel;
import com.grpchat.webServer.services.FileService;
import com.grpchat.webServer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RestMessageController {

    private final MessageService messageService;
    private final FileService fileService;

    @Autowired
    public RestMessageController( MessageService messageService, FileService fileService) {
        this.messageService = messageService;
        this.fileService = fileService;
    }

    @GetMapping("/message/room/{roomId}")
    public List<MessageModel> getInitialMessages(@PathVariable String roomId) {
        return messageService.getInitialMessages(roomId);
    }

    @PostMapping("/files/upload")
    public void fileUpload( @RequestBody FileModel file) {
        file.setTimestamp(LocalDateTime.now());
        fileService.saveFile(file);
    }

    @GetMapping("/files/download/{fileId}")
    public FileModel fileDownload( @PathVariable String fileId) {
        return fileService.getFileById(fileId);
    }

}
