package com.example.controlwork7.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant {
    private Long id;
    private String name;
    private String description;

}
