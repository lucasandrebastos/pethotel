package com.casadalauau.reserva.dtos;

import com.casadalauau.reserva.models.User;

import java.time.LocalDate;

public record PetDTO(
        String name,
        String breed,
        LocalDate birth_date,
        String size,
        boolean is_social,
        String health_plan,
        String feeding_instructions,
        boolean stays_home_alone,
        String potty_location,
        String additional_info,
        String dietary_restrictions,
        String allergies

) {
}
