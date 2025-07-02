package com.casadalauau.reserva.domain.pet.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Veterinarian {
    private String vetName;
    private String phone;
    private String clinicAddress;
}