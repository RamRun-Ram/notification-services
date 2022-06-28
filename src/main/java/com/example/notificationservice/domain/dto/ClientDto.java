package com.example.notificationservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private int mobileOperatorCode;
    private String tag;
    private ZoneId time;

}
