package com.grpchat.webServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        return "users";
    }
}
