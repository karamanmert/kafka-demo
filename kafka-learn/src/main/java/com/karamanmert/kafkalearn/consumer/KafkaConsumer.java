package com.karamanmert.kafkalearn.consumer;

import com.karamanmert.kafkalearn.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 27.12.2024
 */
@Service
public class KafkaConsumer {

    // STRING
    //@KafkaListener(topics = "mert", groupId = "myGroup")
    public void consumeMessage(String message) {
        System.out.printf("Consuming message from the mert topic -> %s%n", message);
    }

    // JSON
    @KafkaListener(topics = "mert", groupId = "myGroup")
    public void consumeJsonMessage(Student student) {
        System.out.printf("Consuming student object from the mert topic -> %s%n", student.toString());
    }
}
