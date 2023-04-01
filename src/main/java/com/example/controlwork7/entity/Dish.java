package com.example.controlwork7.entity;

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
}
