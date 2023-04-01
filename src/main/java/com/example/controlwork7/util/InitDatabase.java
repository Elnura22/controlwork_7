package com.example.controlwork7.util;

import com.example.controlwork7.dao.ClientDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDatabase {
    @Bean
    CommandLineRunner init(ClientDao userDao) {
        return (args) -> {
//            userDao.createTable();
//            taskDao.createTable();
        };
    }
}
