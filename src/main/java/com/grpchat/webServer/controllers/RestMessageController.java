package com.grpchat.webServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestMessageController {
    @GetMapping("/")
    @ResponseBody
    public String getChatServers() {
        return "here are all chat servers";
    }
    @GetMapping("/chat/room/{roomId}")
    @ResponseBody
    public String getInitialMessages(@PathVariable String roomId) {
        return "All messages in room "+roomId;
    }
}
