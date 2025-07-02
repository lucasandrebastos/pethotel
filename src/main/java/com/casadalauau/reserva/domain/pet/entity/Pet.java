package com.casadalauau.reserva.domain.pet.entity;

import com.casadalauau.reserva.domain.client.entity.Client;
import com.casadalauau.reserva.domain.reservation.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_pets")
@Getter
@Setter
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private LocalDate birth_date;
    private String additional_info;
    private String dietary_restrictions;
    private String allergies;
    private boolean isNeutered;
    private String size; // small, medium, large
    private String breed;
    private boolean hasHealthInsurance;
    private String healthInsuranceProvider;
    private String isSocial;
    private String staysAloneWell;
    private String feedingRoutine;
    private String foodRestrictions;
    private boolean canReceiveTreats;
    private int dailyWalks;
    private String pottyHabits;
    private String vomitDiarrheaProtocol;
    private String hygieneNeeds;
    private String personalityNotes;

    @ElementCollection
    private List<String> forbiddenBrands;

    @Embedded
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reservation> reservations;
}



