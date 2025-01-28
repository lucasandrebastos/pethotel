package com.casadalauau.reserva.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pets")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    private String breed;
    private LocalDate birth_date;
    private String size;
    private boolean is_social;
    private String health_plan;
    private String feeding_instructions;
    private boolean stays_home_alone;
    private String potty_location;
    private String additional_info;
    private String dietary_restrictions;
    private String allergies;


}
