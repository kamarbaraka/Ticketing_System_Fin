package com.kamar.ticketing_system_fin.ticket.data;

import com.kamar.ticketing_system_fin.department.entity.Department;
import lombok.Getter;

/**
 * class to hold the required user data.
 * @author kamar baraka.*/

@Getter
public record UserData(
        String email,
        String role,
        String department
) {
}
