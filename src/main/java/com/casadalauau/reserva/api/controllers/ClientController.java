package com.casadalauau.reserva.api.controllers;

import com.casadalauau.reserva.api.dtos.CreateClientDTO;
import com.casadalauau.reserva.api.dtos.CreatePetAndClientDTO;
import com.casadalauau.reserva.domain.client.entity.Client;
import com.casadalauau.reserva.domain.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {

    @Autowired
    ClientService clientService;

//    @PostMapping("/api/clients")
//    public ResponseEntity<String> createPetAndClient(@RequestBody CreatePetAndClientDTO createPetAndClientDTO) {
//        clientService.createClient(createPetAndClientDTO);
//        return ResponseEntity.ok("criado com sucesso");
//
//    }

    @PostMapping("/clients")
    public ResponseEntity<Void> createClientAndPet(@RequestBody CreatePetAndClientDTO dto) {
        clientService.createClientAndPet(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllUsers() {
        try {
            List<Client> response = clientService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
