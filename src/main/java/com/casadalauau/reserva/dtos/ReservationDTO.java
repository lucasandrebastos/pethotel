package com.casadalauau.reserva.dtos;

import com.casadalauau.reserva.models.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public record ReservationDTO(LocalDateTime check_in,
                             LocalDateTime check_out,
                             List<String> services,
                             UserDTO user,
                             PetDTO pet

) {
}
