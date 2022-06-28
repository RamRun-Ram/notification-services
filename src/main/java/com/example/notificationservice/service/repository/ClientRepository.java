package com.example.notificationservice.service.repository;

import com.example.notificationservice.domain.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
}
