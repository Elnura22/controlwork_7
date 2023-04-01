package com.example.controlwork7.service;

import com.example.controlwork7.dao.RestaurantDao;
import com.example.controlwork7.dto.RestaurantDTO;
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
}
