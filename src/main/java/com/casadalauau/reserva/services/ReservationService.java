package com.casadalauau.reserva.services;

import com.casadalauau.reserva.dtos.ReservationDTO;
import com.casadalauau.reserva.models.Pet;
import com.casadalauau.reserva.models.Reservation;
import com.casadalauau.reserva.models.Status;
import com.casadalauau.reserva.models.User;
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
        System.out.println(reservationDTO);

        LocalDateTime checkin = reservationDTO.check_in();
        LocalDateTime checkout = reservationDTO.check_out();
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (checkin.isBefore(currentDateTime) || checkout.isBefore(currentDateTime)) {
            throw new IllegalArgumentException("A data escolhida já passou");
        } else {
            Reservation newReservation = new Reservation();

            BeanUtils.copyProperties(reservationDTO, newReservation);
            newReservation.setStatus(Status.awaiting_admin_approval);
            newReservation.setInventory(null);
            newReservation.setServices(reservationDTO.services());
            newReservation.setCleaning_tax(false);

            User newUser = new User();
            BeanUtils.copyProperties(reservationDTO.user(), newUser);



            Pet newPet = new Pet();
            BeanUtils.copyProperties(reservationDTO.pet(), newPet);



            petRepository.save(newPet);

            Long petId = newPet.getId();
            List<Long> pets = newUser.getPets();
            pets.add(petId);

            userRepository.save(newUser);
            newReservation.setUser_id(newUser.getId());
            newReservation.setPet_id(newPet.getId());
            newPet.setUser_id(newUser.getId());
            newReservation.setCreated_at(currentDateTime);
            newReservation.setUpdate_at(currentDateTime);
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
