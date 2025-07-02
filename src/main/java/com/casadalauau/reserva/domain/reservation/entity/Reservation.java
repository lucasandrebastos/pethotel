package com.casadalauau.reserva.domain.reservation.entity;

import com.casadalauau.reserva.domain.pet.entity.Pet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_reservations")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    @JsonBackReference
    private Pet pet;

    private String serviceType; // boarding, daycare, walk
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private boolean wantsBath;
    private String bathNotes;
    private String status; // pending, accepted, rejected

    @Embedded
    private Transport transport;
}
