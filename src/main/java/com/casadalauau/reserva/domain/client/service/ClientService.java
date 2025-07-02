package com.casadalauau.reserva.domain.client.service;

import com.casadalauau.reserva.api.dtos.*;
import com.casadalauau.reserva.domain.client.entity.Client;
import com.casadalauau.reserva.domain.client.entity.EmergencyContact;
import com.casadalauau.reserva.domain.client.repository.ClientRepository;
import com.casadalauau.reserva.domain.pet.entity.Pet;
import com.casadalauau.reserva.domain.pet.entity.Veterinarian;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void createClient(CreateClientDTO createClientDTO) {
        Client newClient = new Client();
        BeanUtils.copyProperties(createClientDTO, newClient);
        clientRepository.save(newClient);

    }

    public List<Client> getAllUsers() {
        return clientRepository.findAll();
    }

    public void createClientAndPet(CreatePetAndClientDTO dto) {
        Client client = new Client();
        client.setFullName(dto.fullName());
        client.setEmail(dto.email());
        client.setPhone_number(dto.phoneNumber());
        client.setCpf(dto.cpf());
        client.setAddress(dto.address());

        EmergencyContactDTO ecDto = dto.emergencyContact();
        EmergencyContact ec = new EmergencyContact();
        BeanUtils.copyProperties(ecDto, ec);
        client.setEmergencyContact(ec);

        // Separar dados do pet
        CreatePetDTO petDto = dto.pet();
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDto, pet);

        VeterinarianDTO vetDto = petDto.veterinarian();
        Veterinarian vet = new Veterinarian();
        BeanUtils.copyProperties(vetDto, vet);
        pet.setVeterinarian(vet);

        // Relacionar entidades
        pet.setClient(client);
        client.getPets().add(pet);

        clientRepository.save(client);
    }


}
