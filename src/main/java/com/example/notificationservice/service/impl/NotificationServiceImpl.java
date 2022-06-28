package com.example.notificationservice.service.impl;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.domain.dto.NotificationDto;
import com.example.notificationservice.domain.entity.NotificationEntity;
import com.example.notificationservice.mapper.NotificationMapper;
import com.example.notificationservice.service.ClientService;
import com.example.notificationservice.service.NotificationService;
import com.example.notificationservice.service.SenderService;
import com.example.notificationservice.service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final ClientService clientService;
    private final SenderService senderService;

    @Override
    public NotificationDto createNotification(NotificationDto notificationDto, Boolean isSend) {
        NotificationEntity notificationEntity = notificationRepository.save(notificationMapper.notificationToEntity(notificationDto));
        NotificationDto notificationDto1 = notificationMapper.notificationToDto(notificationEntity);
        if (isSend == true) {
            sendNotification(notificationDto1);
        }
        return notificationDto1;
    }
    @Scheduled(fixedRateString = "PT5M")
    public void sheduledSendNotification(){
       findAllNotification().forEach(this::sendNotification);
    }

    public void sendNotification(NotificationDto notificationDto1) {
        if (notificationDto1.getTimeStart().isBefore(LocalDateTime.now()) &&
                LocalDateTime.now().isBefore(notificationDto1.getTimeStop())) {
            List<String> tags = new ArrayList<>();
            List<Integer> phoneCodes = new ArrayList<>();
            notificationDto1.getClientFilterSet().forEach(clientFilterEntity -> {
                tags.add(clientFilterEntity.getTag());
            phoneCodes.add(clientFilterEntity.getMobileOperatorCode());});
            List<ClientDto> clients = clientService.findAllClient().stream()
                    .filter(clientDto -> tags.contains(clientDto.getTag())&& phoneCodes.contains(clientDto.getMobileOperatorCode()))
                    .collect(Collectors.toList());
            clients.forEach(clientDto -> senderService.send(clientDto.getPhoneNumber(), notificationDto1.getMessage()));

        }
    }

    @Override
    public NotificationDto updateNotification(NotificationDto notificationDto) {
        if (notificationDto.getId() != null && notificationRepository.existsById(notificationDto.getId())) {
            NotificationEntity notificationEntity = notificationRepository.save(notificationMapper.notificationToEntity(notificationDto));
            return notificationMapper.notificationToDto(notificationEntity);
        }
//ошибка
        return null;
    }

    public List<NotificationDto> findAllNotification(){
        List<NotificationEntity> notificationEntities = notificationRepository.findAll();
        return notificationMapper.notificationToDtoList(notificationEntities);
    }

    @Override
    public boolean deleteNotification(Long id) {
        if (notificationRepository.existsById(id)) {
            notificationRepository.deleteById(id);
            return true;
        }
        //ошибка
        return false;
    }
}
