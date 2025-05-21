package com.grpchat.webServer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic chatTopic() {
        return new NewTopic("chat-messages", 3, (short) 1); // topic name, partitions, replication factor
    }
}