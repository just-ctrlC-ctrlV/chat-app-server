package com.grpchat.webServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomModel {
    @JsonProperty("id")
    private Long roomId;
    @JsonProperty("name")
    private String roomName;
}
