package com.example.controlwork7.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Order {

    private Long id;
    @JsonProperty("client_id")
    private Long clientId;
    @JsonProperty("dish_id")
    private Long dishId;
    private LocalDateTime date;
}
