package com.casadalauau.reserva.api.dtos;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreatePetDTO(
        String name,
        LocalDate birth_date,
        String additional_info,
        String dietary_restrictions,
        String allergies,
        boolean isNeutered,
        String size, // small, medium, large
        String breed,
        boolean hasHealthInsurance,
        String healthInsuranceProvider,
        String isSocial,
        String staysAloneWell,
        String feedingRoutine,
        String foodRestrictions,
        boolean canReceiveTreats,
        int dailyWalks,
        String pottyHabits,
        String vomitDiarrheaProtocol,
        String hygieneNeeds,
        String personalityNotes,
        List<String> forbiddenBrands,
        VeterinarianDTO veterinarian,
        UUID clientId
) {}
