package com.grpchat.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String name;
    private String email;
    @JsonProperty("password")
    private String encryptedPassword;
    private String profilePic;
    @JsonProperty("phone")
    private String phoneNumber;
    List<String> subscribedToChatRooms;
}
