package com.grpchat.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileModel {
    private Long id;
    private String fileId;
    private String fileName;
    private String mimeType;
    @JsonProperty("sender")
    private String senderId;
    @JsonProperty("room")
    private String roomId;
    private String content;
    private LocalDateTime timestamp;
}
