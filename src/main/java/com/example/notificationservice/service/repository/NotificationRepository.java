package com.example.notificationservice.service.repository;

import com.example.notificationservice.domain.entity.NotificationEntity;
import com.example.notificationservice.service.NotificationService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
}
