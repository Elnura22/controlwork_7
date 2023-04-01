package com.example.controlwork7.service;

import com.example.controlwork7.dao.DishDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishDao dishDao;
}
