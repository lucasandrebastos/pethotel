package com.casadalauau.reserva.services;

import com.casadalauau.reserva.dtos.UserDTO;
import com.casadalauau.reserva.models.User;
import com.casadalauau.reserva.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(UserDTO userDTO){
        User newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);
        userRepository.save(newUser);

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
