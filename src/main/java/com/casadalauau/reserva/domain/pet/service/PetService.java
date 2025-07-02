package com.casadalauau.reserva.domain.pet.service;

import com.casadalauau.reserva.api.dtos.CreatePetDTO;
import com.casadalauau.reserva.domain.client.entity.Client;
import com.casadalauau.reserva.domain.pet.entity.Pet;
import com.casadalauau.reserva.domain.pet.entity.Veterinarian;
import com.casadalauau.reserva.domain.pet.repository.PetRepository;
import com.casadalauau.reserva.domain.client.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    ClientRepository clientRepository;

    public void createPet(CreatePetDTO createPetDTO) {
        Pet newPet = new Pet();
        BeanUtils.copyProperties(createPetDTO, newPet);
        Client client = clientRepository.findById(createPetDTO.clientId()).orElseThrow();
        newPet.setClient(client);
        Veterinarian vet = new Veterinarian();
        BeanUtils.copyProperties(createPetDTO.veterinarian(), vet);
        newPet.setVeterinarian(vet);
        petRepository.save(newPet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
