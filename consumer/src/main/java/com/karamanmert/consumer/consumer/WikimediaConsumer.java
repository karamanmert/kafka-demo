package com.karamanmert.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 29.12.2024
 */

@Service
public class WikimediaConsumer {

    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeMessage(String message) {
        System.out.printf("Consuming message from the wikimedia-stream topic -> %s%n", message);
    }
}
