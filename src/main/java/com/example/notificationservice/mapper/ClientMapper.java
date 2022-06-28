package com.example.notificationservice.mapper;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.domain.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientDto clientToDto(ClientEntity clientEntity);
    ClientEntity clientToEntity(ClientDto clientDto);
    List<ClientDto> clientToDtoList(List<ClientEntity> clientEntity);
}
