package com.example.controlwork7.service;

import com.example.controlwork7.dao.DishDao;
import com.example.controlwork7.dao.RestaurantDao;
import com.example.controlwork7.dto.DishDTO;
import com.example.controlwork7.entity.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishDao dishDao;

    private final RestaurantDao restaurantDao;

    public List<DishDTO> getListOfDishes(Long id) {
        var listOfDishes = dishDao.getListById(id);
        return listOfDishes.stream().map(DishDTO::from).collect(Collectors.toList());
    }

    public DishDTO createDish(DishDTO dishDTO) {
        Dish dish = Dish.builder()
                .id(dishDTO.getId())
                .name(dishDTO.getName())
                .type(dishDTO.getType())
                .price(dishDTO.getPrice())
                .restaurantId(dishDTO.getRestaurantId())
                .build();
        dishDao.save(dish);
        return DishDTO.from(dish);
    }
}
