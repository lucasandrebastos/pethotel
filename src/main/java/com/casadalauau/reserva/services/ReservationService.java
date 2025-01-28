package com.casadalauau.reserva.services;

import com.casadalauau.reserva.dtos.ReservationDTO;
import com.casadalauau.reserva.models.Reservation;
import com.casadalauau.reserva.models.Status;
import com.casadalauau.reserva.repositories.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

public void createReservation(ReservationDTO reservationDTO){
    Reservation newReservation = new Reservation();
    BeanUtils.copyProperties(reservationDTO, newReservation);
    newReservation.setStatus(Status.awaiting_admin_approval);
    newReservation.setInventory(null);
    newReservation.setOther_services(null);
    newReservation.setCleaning_tax(false);
    reservationRepository.save(newReservation);
}

public List<Reservation> getAllReservations(){
    return reservationRepository.findAll();
}
}
