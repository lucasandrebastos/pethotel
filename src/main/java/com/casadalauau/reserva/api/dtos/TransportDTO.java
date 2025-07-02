package com.casadalauau.reserva.api.dtos;

public record TransportDTO(
         boolean required,
         String pickupAddress,
         String returnAddress,
         String notes,
         Double fee
) {
}
