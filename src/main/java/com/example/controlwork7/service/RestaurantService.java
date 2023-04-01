package com.example.controlwork7.service;

import com.example.controlwork7.dao.RestaurantDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantDao restaurantDao;

}
