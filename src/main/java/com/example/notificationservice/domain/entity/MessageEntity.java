package com.example.notificationservice.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeCreatingMessage;
    private boolean isStatusMessage;
    @OneToOne
    private NotificationEntity notification;
    @OneToOne
    private ClientEntity client;
}
