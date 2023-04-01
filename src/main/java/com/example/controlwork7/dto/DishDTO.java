package com.example.controlwork7.dto;

import com.example.controlwork7.entity.Dish;
import com.example.controlwork7.entity.Restaurant;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DishDTO {

    public static DishDTO from(Dish dish) {
        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .type(dish.getType())
                .price(dish.getPrice())
                .restaurantId(dish.getRestaurantId())
                .build();
    }

    private Long id;
    private String name;
    private String type;
    private Long price;
    @JsonProperty("restaurant_id")
    private Long restaurantId;
}
