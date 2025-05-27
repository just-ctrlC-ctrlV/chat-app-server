package com.grpchat.webServer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty("password")
    @Column(name = "encrypted_password", nullable = false)
    private String encryptedPassword;

    @Column(columnDefinition = "TEXT")
    private String profilePic;
    @JsonProperty("phone")
    private String phoneNumber;

    @ElementCollection
    @CollectionTable(
            name = "user_chatrooms",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "chat_room", nullable = false)
    private List<String> subscribedToChatRooms;
}
