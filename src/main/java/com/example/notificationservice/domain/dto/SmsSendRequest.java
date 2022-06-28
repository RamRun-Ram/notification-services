package com.example.notificationservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SmsSendRequest {
    private Long id;
    private Long phone;
    private String text;
}
