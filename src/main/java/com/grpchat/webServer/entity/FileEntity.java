package com.grpchat.webServer.entity;

import jakarta.persistence.Table;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Enabled
@Getter
@Setter
@Table(name = "files")
public class FileEntity {
    private String fileName;
    private String mimeType;
    private String senderId;
    private String roomId;
    private LocalDateTime timestamp;
}
