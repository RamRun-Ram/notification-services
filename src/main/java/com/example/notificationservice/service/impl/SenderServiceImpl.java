package com.example.notificationservice.service.impl;

import com.example.notificationservice.domain.dto.SmsSendRequest;
import com.example.notificationservice.domain.dto.SmsSendResponse;
import com.example.notificationservice.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class SenderServiceImpl implements SenderService {
    private final RestTemplate restTemplate;
    @Value("${services.sms-sender.token}")
    private String token;




    @Override
    public void send(String phoneNumber, String message) {
        String path = UriComponentsBuilder.fromPath("/send").pathSegment("1").toUriString();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(token);
        SmsSendRequest body = new SmsSendRequest(1L,Long.parseLong(phoneNumber),message);
restTemplate.exchange(path, HttpMethod.POST,new HttpEntity<>(body,httpHeaders),SmsSendResponse.class);
    }


}
