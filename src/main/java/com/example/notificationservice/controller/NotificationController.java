package com.example.notificationservice.controller;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.domain.dto.NotificationDto;
import com.example.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public NotificationDto createNotification(@RequestBody NotificationDto notificationDto, Boolean isSend) {
        return notificationService.createNotification(notificationDto,isSend);
    }

    @PutMapping
    public NotificationDto updateNotification(@RequestBody NotificationDto notificationDto) {
        return notificationService.updateNotification(notificationDto);
    }
    @GetMapping("/all")
    public List<NotificationDto> findAllNotification(){
        return notificationService.findAllNotification();
    }

    @DeleteMapping
    public boolean deleteNotification(Long id) {
        return notificationService.deleteNotification(id);
    }
}
