package com.casadalauau.reserva.domain.reservation.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Transport {
    private boolean required;
    private String pickupAddress;
    private String returnAddress;
    private String notes;
    private Double fee;
}