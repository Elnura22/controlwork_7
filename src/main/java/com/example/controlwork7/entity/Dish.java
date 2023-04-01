package com.example.controlwork7.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Dish {

    private Long id;
    private String name;
    private String type;
    private Long price;
    @JsonProperty("restaurant_id")
    private Long restaurantId;
}
