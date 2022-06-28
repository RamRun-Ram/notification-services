package com.example.notificationservice.domain.dto;

import com.example.notificationservice.domain.entity.ClientFilterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private Long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeStop;
    private String message;
    private Set<ClientFilterEntity> clientFilterSet;
}
