package com.casadalauau.reserva.api.dtos;

public record CreatePetAndClientDTO(
        String fullName,
        String email,
        String phoneNumber,
        String cpf,
        String address,
        EmergencyContactDTO emergencyContact,
        CreatePetDTO pet
) {}
