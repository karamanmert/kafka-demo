package com.karamanmert.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author karamanmert
 * @date 29.12.2024
 */
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
