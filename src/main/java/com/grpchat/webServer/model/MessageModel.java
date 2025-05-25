package com.grpchat.webServer.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageModel {

        private String sender;
        private String content;
        private String room;
        private LocalDateTime timestamp;
        private Boolean isFile;
        private String fileId;
        private String replyOn;

}
