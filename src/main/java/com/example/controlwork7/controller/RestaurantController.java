package com.example.controlwork7.controller;

import com.example.controlwork7.dto.RestaurantDTO;
import com.example.controlwork7.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService service;

    //Мы можем получать список заведений;
    @GetMapping("/getList")
    public ResponseEntity<List<RestaurantDTO>> getList(){
        return new ResponseEntity<>(service.getListOfRestaurants(), HttpStatus.OK);
    }


}
