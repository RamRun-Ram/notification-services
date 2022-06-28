package com.example.notificationservice.service.impl;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.domain.entity.ClientEntity;
import com.example.notificationservice.mapper.ClientMapper;
import com.example.notificationservice.service.ClientService;
import com.example.notificationservice.service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDto createClient(ClientDto client) {
        ClientEntity clientEntity = clientRepository.save(clientMapper.clientToEntity(client));
        return clientMapper.clientToDto(clientEntity);
    }

    @Override
    public ClientDto findClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElseThrow(RuntimeException::new);
         return clientMapper.clientToDto(clientEntity);
    }

    @Override
    public List<ClientDto> findAllClient() {
        List<ClientEntity> clientEntity = clientRepository.findAll();
        return clientMapper.clientToDtoList(clientEntity);
    }

    @Override
    public ClientDto updateClient(ClientDto client) {
        if (client.getId() != null && clientRepository.existsById(client.getId())) {
            ClientEntity clientEntity = clientRepository.save(clientMapper.clientToEntity(client));
            return clientMapper.clientToDto(clientEntity);
        }
//       ошибка
        return null;
    }

    @Override
    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        //ошибка
        return false;
    }
}
