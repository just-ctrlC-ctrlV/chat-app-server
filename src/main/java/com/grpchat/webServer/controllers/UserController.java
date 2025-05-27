package com.grpchat.webServer.controllers;

import com.grpchat.webServer.model.UserModel;
import com.grpchat.webServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{email}")
    public UserModel getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @PostMapping("/user")
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }
    @PostMapping("/user/{email}/add/room/{roomId}")
    public void addUserToRoom(@PathVariable String email,@PathVariable String roomId) {
        userService.addUserToRoom(email,roomId);
    }
}
