package com.casadalauau.reserva.domain.client.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class EmergencyContact {
    private String name;
    private String phone;
}
