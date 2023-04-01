package com.example.controlwork7.service;

import com.example.controlwork7.dao.ClientDao;
import com.example.controlwork7.dao.OrderDao;
import com.example.controlwork7.dto.OrderDTO;
import com.example.controlwork7.entity.Client;
import com.example.controlwork7.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;

    private final ClientDao clientDao;

    public List<OrderDTO> getListOfOrders(String email) {
        Client client = clientDao.findClientByEmail(email).orElseThrow();
        List<Order> orderList = orderDao.getListOfOrders(client.getId());
        for (Order order : orderList) {
            if (order.getClientId().equals(client.getId())) {
                return orderList.stream().map(OrderDTO::from).collect(Collectors.toList());
            }
        }
        return orderList.stream().map(OrderDTO::from).collect(Collectors.toList());
    }

    public OrderDTO createOrder(OrderDTO orderDTO, String email) {
        Client client = clientDao.findClientByEmail(email).orElseThrow();
        Order order = Order.builder()
                .id(orderDTO.getId())
                .clientId(client.getId())
                .dishId(orderDTO.getDishId())
                .date(orderDTO.getDate())
                .build();
        orderDao.save(order);
        return OrderDTO.from(order);
    }


}
