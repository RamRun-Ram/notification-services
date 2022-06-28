package com.example.notificationservice.controller;

import com.example.notificationservice.domain.dto.ClientDto;
import com.example.notificationservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto client) {
        return clientService.createClient(client);
    }

    @GetMapping
    public ClientDto findClient(@RequestParam Long id) {
        return clientService.findClient(id);
    }

    @GetMapping("/all")
    public List<ClientDto> findAllClient(){
        return clientService.findAllClient();
    }

    @PutMapping
    public ClientDto updateClient(@RequestBody ClientDto client) {
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }


}
