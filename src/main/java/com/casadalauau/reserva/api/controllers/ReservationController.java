package com.casadalauau.reserva.api.controllers;


import com.casadalauau.reserva.domain.reservation.service.ReservationService;
import com.casadalauau.reserva.api.dtos.CreateReservationDTO;
import com.casadalauau.reserva.domain.reservation.entity.Reservation;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public ResponseEntity<String> createReservation(@RequestBody CreateReservationDTO createReservationDTO) {
        reservationService.createReservation(createReservationDTO);
        return ResponseEntity.ok("Reserva criada com sucesso");
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {

        try {
            List<Reservation> response = reservationService.getAllReservations();
            if (response.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.ok(response);

        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        } catch (TransactionException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}


