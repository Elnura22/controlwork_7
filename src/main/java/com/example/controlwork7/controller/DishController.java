package com.example.controlwork7.controller;

import com.example.controlwork7.dto.DishDTO;
import com.example.controlwork7.dto.RestaurantDTO;
import com.example.controlwork7.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {
    private final DishService service;

    @GetMapping("/getListById")
    public ResponseEntity<List<DishDTO>> getList(@PathVariable Long id){
        return new ResponseEntity<>(service.getListOfDishes(id), HttpStatus.OK);
    }
}
