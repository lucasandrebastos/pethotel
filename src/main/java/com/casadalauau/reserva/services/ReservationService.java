package com.casadalauau.reserva.services;

import com.casadalauau.reserva.dtos.ReservationDTO;
import com.casadalauau.reserva.models.Reservation;
import com.casadalauau.reserva.models.Status;
import com.casadalauau.reserva.repositories.PetRepository;
import com.casadalauau.reserva.repositories.ReservationRepository;
import com.casadalauau.reserva.repositories.UserRepository;
import org.hibernate.TransactionException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PetRepository petRepository;

    public void createReservation(ReservationDTO reservationDTO) {

        Reservation newReservation = new Reservation();
        LocalDateTime checkin = reservationDTO.check_in();
        LocalDateTime checkout = reservationDTO.check_out();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Long userId = reservationDTO.user_id();
        boolean userExists = userRepository.existsById(userId);
        Long petId = reservationDTO.pet_id();
        boolean petExists = petRepository.existsById(petId);
        if (!userExists) {
            throw new IllegalArgumentException("Usuário não existe");
        } else if (!petExists) {
            throw new IllegalArgumentException("Pet não existe");
        } else if (checkin.isBefore(currentDateTime) || checkout.isBefore(currentDateTime)) {
            throw new IllegalArgumentException("A data escolhida já passou");
        } else {
            BeanUtils.copyProperties(reservationDTO, newReservation);
            newReservation.setStatus(Status.awaiting_admin_approval);
            newReservation.setInventory(null);
            newReservation.setOther_services(null);
            newReservation.setCleaning_tax(false);
            reservationRepository.save(newReservation);
        }

    }

    public List<Reservation> getAllReservations() {

        try {
            return reservationRepository.findAll();
        } catch (NullPointerException e) {
            System.err.println("Erro: O repositório de reservas não foi injetado corretamente. " + e.getMessage());
        } catch (DataAccessException e) {
            System.err.println("Erro ao acessar o banco de dados: " + e.getMessage());
        } catch (TransactionException e) {
            System.err.println("Erro de transação ao buscar reservas: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado ao buscar reservas: " + e.getMessage());
        }
        return Collections.emptyList();
    }


}
