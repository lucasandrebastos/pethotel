package com.casadalauau.reserva.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_reservations")
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<String> inventory;

    private LocalDateTime check_in;

    private LocalDateTime check_out;

    private boolean cleaning_tax;

    private List<String> services = new ArrayList<>();

    private Long user_id;

    private Long pet_id;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime created_at;

    @Column(name = "update_at")
    private LocalDateTime update_at;

    private Status status;


}
