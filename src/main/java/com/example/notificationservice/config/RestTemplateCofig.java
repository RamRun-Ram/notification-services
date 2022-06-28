package com.example.notificationservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;

@Configuration
public class RestTemplateCofig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder
                .rootUri("https://probe.fbrq.cloud/v1")
                .setConnectTimeout(Duration.ofMillis(300000))
                .build();

    }
}
