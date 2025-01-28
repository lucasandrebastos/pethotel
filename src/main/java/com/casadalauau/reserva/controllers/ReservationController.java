package com.casadalauau.reserva.controllers;


import com.casadalauau.reserva.services.ReservationService;
import com.casadalauau.reserva.dtos.ReservationDTO;
import com.casadalauau.reserva.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservations")
    public ResponseEntity<String> createReservatio(@RequestBody ReservationDTO reservationDTO) {
        reservationService.createReservation(reservationDTO);
        return ResponseEntity.ok("Reserva criada com sucesso");
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {

        try {
            List<Reservation> response = reservationService.getAllReservations();
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
