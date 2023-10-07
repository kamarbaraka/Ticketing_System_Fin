package com.kamar.ticketing_system_fin.user.entity;

import com.kamar.ticketing_system_fin.department.entity.Department;
import jakarta.persistence.*;
import lombok.Data;

/**
 * the normal user in the system.
 * @author kamar baraka.*/

@Entity
@Data
public class NormalUser {

    @Id
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String role;
//    @JoinTable(name = "department")
    @ManyToOne
    private Department department;
}
