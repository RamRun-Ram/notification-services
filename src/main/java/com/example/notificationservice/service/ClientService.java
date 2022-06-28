package com.example.notificationservice.service;

import com.example.notificationservice.domain.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto createClient(ClientDto client);
    ClientDto findClient(Long id);
    List<ClientDto> findAllClient();
    ClientDto updateClient(ClientDto client);
    boolean deleteClient(Long id);
}
