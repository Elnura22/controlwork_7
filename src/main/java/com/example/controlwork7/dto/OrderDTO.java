package com.example.controlwork7.dto;

import com.example.controlwork7.entity.Order;
import com.example.controlwork7.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {

    public static OrderDTO from(Order order) {
        return builder()
                .id(order.getId())
                .clientId(order.getClientId())
                .dishId(order.getDishId())
                .date(order.getDate())
                .build();
    }

    private Long id;
    @JsonProperty("client_id")
    private Long clientId;
    @JsonProperty("dish_id")
    private Long dishId;
    private LocalDateTime date;
}
