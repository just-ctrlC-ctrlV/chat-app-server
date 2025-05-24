package com.grpchat.webServer.model;

import lombok.*;

@Getter
@Setter
public class MessageModel {

        private String sender;
        private String content;
        private String room;

}
