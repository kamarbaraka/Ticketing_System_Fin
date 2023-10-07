package com.kamar.ticketing_system_fin.user.data;

import lombok.Getter;

/**
 * the user DTO.
 * @author kamar baraka.*/

@Getter
public record UserDTO(
        String email,
        String role,
        String department
) {
}
