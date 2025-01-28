package com.casadalauau.reserva.repositories;

import com.casadalauau.reserva.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long > {
}
