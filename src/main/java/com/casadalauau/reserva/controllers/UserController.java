package com.casadalauau.reserva.controllers;

import com.casadalauau.reserva.dtos.UserDTO;
import com.casadalauau.reserva.models.User;
import com.casadalauau.reserva.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("criado com sucesso");

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> response = userService.getAllUsers();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
