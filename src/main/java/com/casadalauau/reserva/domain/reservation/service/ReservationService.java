package com.casadalauau.reserva.domain.reservation.service;

import com.casadalauau.reserva.api.dtos.CreateReservationDTO;
import com.casadalauau.reserva.domain.pet.entity.Pet;
import com.casadalauau.reserva.domain.reservation.entity.Reservation;
import com.casadalauau.reserva.domain.reservation.entity.Transport;
import com.casadalauau.reserva.domain.reservation.repository.ReservationRepository;
import com.casadalauau.reserva.domain.client.entity.Client;
import com.casadalauau.reserva.domain.pet.repository.PetRepository;
import com.casadalauau.reserva.domain.client.repository.ClientRepository;
import org.hibernate.TransactionException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.constant.PackageDesc;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PetRepository petRepository;

    public void createReservation(CreateReservationDTO createReservationDTO) {
        System.out.println(createReservationDTO);

        LocalDateTime checkin = createReservationDTO.checkIn();
        LocalDateTime checkout = createReservationDTO.checkOut();
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (checkin.isBefore(currentDateTime) || checkout.isBefore(currentDateTime)) {
            throw new IllegalArgumentException("A data escolhida já passou");
        } else {
            Reservation newReservation = new Reservation();
            BeanUtils.copyProperties(createReservationDTO, newReservation);
            Transport transport = new Transport();
            BeanUtils.copyProperties(createReservationDTO.transport(), transport);
            newReservation.setTransport(transport);
            Pet pet = petRepository.findById(createReservationDTO.pet()).orElseThrow();
            newReservation.setPet(pet);
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
