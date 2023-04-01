package com.example.controlwork7.controller;

import com.example.controlwork7.dto.RestaurantDTO;
import com.example.controlwork7.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //create new restaurants for checking
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantDTO createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return service.createRestaurant(restaurantDTO);
    }
}
