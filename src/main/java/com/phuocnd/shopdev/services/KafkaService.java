package com.phuocnd.shopdev.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "your_topic_name", groupId = "your_group_id")
    public void listen() {
        // Process the incoming message
    }
}
