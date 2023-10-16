package com.kamar.ticketing_system_fin.ticket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class to represent a task.
 * @author kamar baraka.*/

@Entity
@Data
public class Tasks {

    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private long taskId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private boolean complete = false;
}
