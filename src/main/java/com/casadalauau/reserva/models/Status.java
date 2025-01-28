package com.casadalauau.reserva.models;

public enum Status {
    awaiting_admin_approval,
    awaiting_deposit_payment,
    reservation_scheduled,
    reservation_canceled,
    reservation_in_progress,
    reservation_completed,
}
