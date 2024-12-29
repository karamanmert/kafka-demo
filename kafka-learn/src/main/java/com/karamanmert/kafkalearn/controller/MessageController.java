package com.karamanmert.kafkalearn.controller;

import com.karamanmert.kafkalearn.payload.Student;
import com.karamanmert.kafkalearn.producer.KafkaJsonProducer;
import com.karamanmert.kafkalearn.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author karamanmert
 * @date 27.12.2024
 */

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    public MessageController(KafkaProducer kafkaProducer, KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    // STRING MESSAGE
    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    // OBJECT MESSAGE AS JSON
    @PostMapping("/json")
    public ResponseEntity<String> publishMessage(@RequestBody Student student) {
        kafkaJsonProducer.publishMessage(student);
        return ResponseEntity.ok("Message queued successfully as Json");
    }
}
