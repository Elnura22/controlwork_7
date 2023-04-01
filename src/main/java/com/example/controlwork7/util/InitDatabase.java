package com.example.controlwork7.util;

import com.example.controlwork7.dao.ClientDao;
import com.example.controlwork7.dao.DishDao;
import com.example.controlwork7.dao.OrderDao;
import com.example.controlwork7.dao.RestaurantDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDatabase {
    @Bean
    CommandLineRunner init(ClientDao clientDao, DishDao dishDao, OrderDao orderDao, RestaurantDao restaurantDao) {
        return (args) -> {
            clientDao.createTable();
            dishDao.createTable();
            orderDao.createTable();
            restaurantDao.createTable();

        };
    }
}
