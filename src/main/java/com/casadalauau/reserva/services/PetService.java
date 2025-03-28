package com.casadalauau.reserva.services;

import com.casadalauau.reserva.dtos.PetDTO;
import com.casadalauau.reserva.models.Pet;
import com.casadalauau.reserva.models.User;
import com.casadalauau.reserva.repositories.PetRepository;
import com.casadalauau.reserva.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;
    @Autowired
    UserRepository userRepository;

    public void createPet(PetDTO petDTO) {
        Pet newPet = new Pet();
        BeanUtils.copyProperties(petDTO, newPet);
//        Long userId = petDTO.user_id();
//        newPet.setTutor_id(userId);
//        petRepository.save(newPet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
