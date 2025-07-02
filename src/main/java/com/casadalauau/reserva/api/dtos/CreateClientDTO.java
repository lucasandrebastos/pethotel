package com.casadalauau.reserva.api.dtos;

import java.util.List;

public record CreateClientDTO(
        String fullName,
        String email,
        String phone_number,
        EmergencyContactDTO emergencyContact,
        String cpf,
        String address,
        List<CreatePetDTO> pets

) {
}
