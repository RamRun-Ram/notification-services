package com.example.notificationservice.service;

import com.example.notificationservice.domain.dto.NotificationDto;

import java.util.List;

public interface NotificationService {
    NotificationDto createNotification(NotificationDto notificationDto,Boolean isSend);
    NotificationDto updateNotification(NotificationDto notificationDto);
    List<NotificationDto> findAllNotification();
    boolean deleteNotification(Long id);

}
