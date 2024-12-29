package com.karamanmert.producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 29.12.2024
 */

@Service
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessages(String message) {
        kafkaTemplate.send("wikimedia-stream", message);
    }
}
