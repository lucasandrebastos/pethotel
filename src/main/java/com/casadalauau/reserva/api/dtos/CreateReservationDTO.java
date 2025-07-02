package com.casadalauau.reserva.api.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateReservationDTO(
        UUID pet,
        String serviceType,
        LocalDateTime checkIn,
        LocalDateTime checkOut,
        boolean wantsBath,
        String bathNotes,
        String status,
        TransportDTO transport
) {
}
