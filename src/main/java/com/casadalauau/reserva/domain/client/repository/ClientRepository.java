package com.casadalauau.reserva.domain.client.repository;

import com.casadalauau.reserva.domain.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    
}
