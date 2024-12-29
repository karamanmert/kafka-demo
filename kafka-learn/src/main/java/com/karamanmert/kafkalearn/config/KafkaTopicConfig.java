package com.karamanmert.kafkalearn.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author karamanmert
 * @date 27.12.2024
 */

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic mertTopic() {
        return TopicBuilder.name("mert")
                //.partitions()
                //.replicas()
                .build();
    }
}
