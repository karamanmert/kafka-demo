package com.karamanmert.kafkalearn.producer;

import com.karamanmert.kafkalearn.payload.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 * @date 27.12.2024
 */
@Service
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, Student> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(Student student) {
        System.out.printf("Sending student to mert topic as JSON -> %s%n", student.toString());

        Message<Student> message = MessageBuilder.withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "mert")
                .build();

        kafkaTemplate.send(message);
    }
}
