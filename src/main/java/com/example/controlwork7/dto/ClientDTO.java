package com.example.controlwork7.dto;

import com.example.controlwork7.entity.Client;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ClientDTO {
    public static ClientDTO from(Client client) {
        return builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .enabled(client.isEnabled())
                .build();
    }
    private Long id;
    private String name;
    private String email;
    private boolean enabled = Boolean.TRUE;
}
