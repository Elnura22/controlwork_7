package com.example.controlwork7.controller;

import com.example.controlwork7.dto.ClientDTO;
import com.example.controlwork7.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    @PostMapping("/register")
    public ResponseEntity<?> registration(@RequestBody ClientDTO userDTO, @RequestParam String password){
        if (service.userExists(userDTO.getName())) {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(service.registerNewUser(userDTO, password));
    }
}
