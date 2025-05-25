package com.grpchat.webServer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("sender")
    private String senderId;
    @JsonProperty("room")
    private String roomId;
    @JsonProperty("content")
    private String content;
    private LocalDateTime timestamp;
    private Boolean isFile;
    private String fileId;
    private String replyOn;


    public MessageEntity(String sender, String content, String room, LocalDateTime timestamp,Boolean isFile,String fileId,String replyOn) {
        this.senderId = sender;
        this.content = content;
        this.roomId = room;
        this.timestamp = timestamp;
        this.isFile = isFile;
        this.fileId = fileId;
        this.replyOn = replyOn;
    }
}
