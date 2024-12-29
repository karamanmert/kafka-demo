package com.karamanmert.producer.stream;

import com.karamanmert.producer.producer.WikimediaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author karamanmert
 * @date 29.12.2024
 */
@Service
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public WikimediaStreamConsumer(WebClient.Builder webClientBuilder,
                                   WikimediaProducer producer) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessages);
    }
}
