package com.example.controlwork7.controller;

import com.example.controlwork7.dto.DishDTO;
import com.example.controlwork7.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishController {
    private final DishService service;

    //По каждому заведению мы можем просматривать список блюд;
    @GetMapping("/getListOfDishesByRestaurantId/{id}")
    public ResponseEntity<List<DishDTO>> getList(@PathVariable Long id){
        return new ResponseEntity<>(service.getListOfDishes(id), HttpStatus.OK);
    }

    //create dishes for checking
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DishDTO createDishes(@RequestBody DishDTO dishDTO) {
        return service.createDish(dishDTO);
    }
}
