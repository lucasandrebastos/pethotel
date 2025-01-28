package com.casadalauau.reserva.dtos;

import com.casadalauau.reserva.models.UserRole;

public record UserDTO(
        String name,
        String email,
        String phone_number,
        String emergency_phone_number,
        UserRole userRole,
        String cpf,
        String address

) {
}
