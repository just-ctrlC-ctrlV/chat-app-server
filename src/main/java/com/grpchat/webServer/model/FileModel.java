package com.grpchat.webServer.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
    private String fileName;
    private String mimeType;
    private String senderId;
    private String roomId;
    private LocalDateTime timestamp;
}
