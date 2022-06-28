package com.example.notificationservice.mapper;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.domain.dto.NotificationDto;
import com.example.notificationservice.domain.entity.ClientEntity;
import com.example.notificationservice.domain.entity.NotificationEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface NotificationMapper {
    NotificationEntity notificationToEntity(NotificationDto notificationDto);
    NotificationDto notificationToDto(NotificationEntity notificationEntity);
    List<NotificationDto> notificationToDtoList(List<NotificationEntity> notificationEntities);
}
