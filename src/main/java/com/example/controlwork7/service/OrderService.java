package com.example.controlwork7.service;

import com.example.controlwork7.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;
}
