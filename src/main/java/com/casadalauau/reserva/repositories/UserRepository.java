package com.casadalauau.reserva.repositories;

import com.casadalauau.reserva.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    
}
