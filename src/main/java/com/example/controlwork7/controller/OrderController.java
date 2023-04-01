package com.example.controlwork7.controller;

import com.example.controlwork7.dto.OrderDTO;
import com.example.controlwork7.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;


    //Мы можем просмотреть список своих заказов.
    @GetMapping
    public List<OrderDTO> getListOfOrders(Authentication authentication) {
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        return service.getListOfOrders(ud.getUsername());
    }

    //create new order
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO, Authentication authentication) {
        UserDetails ud = (UserDetails) authentication.getPrincipal();
        return service.createOrder(orderDTO, ud.getUsername());
    }

}
