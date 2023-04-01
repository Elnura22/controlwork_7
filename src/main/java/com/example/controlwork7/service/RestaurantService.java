package com.example.controlwork7.service;

import com.example.controlwork7.dao.RestaurantDao;
import com.example.controlwork7.dto.RestaurantDTO;
import com.example.controlwork7.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantDao restaurantDao;

    public List<RestaurantDTO> getListOfRestaurants() {
        var restaurantsList = restaurantDao.getListOfRestaurants();
        return restaurantsList.stream().map(RestaurantDTO::from).collect(Collectors.toList());
    }

    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = Restaurant.builder()
                .id(restaurantDTO.getId())
                .name(restaurantDTO.getName())
                .description(restaurantDTO.getDescription())
                .build();
        restaurantDao.save(restaurant);
        return RestaurantDTO.from(restaurant);
    }
}
