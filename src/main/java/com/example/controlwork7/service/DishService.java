package com.example.controlwork7.service;

import com.example.controlwork7.dao.DishDao;
import com.example.controlwork7.dto.DishDTO;
import com.example.controlwork7.dto.RestaurantDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishDao dishDao;


    public List<DishDTO> getListOfDishes(Long id) {
        var listOfDishes = dishDao.getListById(id);
        return listOfDishes.stream().map(DishDTO::from).collect(Collectors.toList());
    }
}
