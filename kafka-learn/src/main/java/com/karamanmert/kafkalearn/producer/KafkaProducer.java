package com.karamanmert.kafkalearn.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 27.12.2024
 */
@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String message) {
        System.out.printf("Sending message to mert topic -> %s%n", message);
        kafkaTemplate.send("mert", message); // mert is a topic name in KafkaTopicConfig
    }
}
