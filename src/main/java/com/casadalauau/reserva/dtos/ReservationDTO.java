package com.casadalauau.reserva.dtos;

import java.util.Date;

public record ReservationDTO(Date check_in, Date check_out, Long client_id, Long pet_id) {
}
