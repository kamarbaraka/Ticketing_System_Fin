package com.kamar.ticketing_system_fin.department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


/**
 * a representation of a department in the company.
 * @author kamar baraka.*/


@Entity
@Data
public class Department {

    @Id
    @Column(nullable = false, unique = true)
    private String departmentName;
    private String description;

}
