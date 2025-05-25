package com.grpchat.webServer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "files")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String fileId;
    private String fileName;
    private String mimeType;
    @JsonProperty("sender")
    private String senderId;
    @JsonProperty("room")
    private String roomId;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime timestamp;
}
