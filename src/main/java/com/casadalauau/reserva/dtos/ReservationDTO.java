package com.casadalauau.reserva.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public record ReservationDTO(LocalDateTime check_in, LocalDateTime check_out, Long user_id, Long pet_id) {
}
