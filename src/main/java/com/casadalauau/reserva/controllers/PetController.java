package com.casadalauau.reserva.controllers;

import com.casadalauau.reserva.dtos.PetDTO;
import com.casadalauau.reserva.models.Pet;
import com.casadalauau.reserva.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping("/pets")
    public ResponseEntity<String> createPet(@RequestBody PetDTO petDTO) {
        petService.createPet(petDTO);
        return ResponseEntity.ok("Pet criado com sucesso");
    }

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        try {
            List<Pet> response = petService.getAllPets();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
}
