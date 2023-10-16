package com.kamar.ticketing_system_fin.ticket.entity;

import com.kamar.ticketing_system_fin.ticket.data.DTOType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * tickets class to hold ticket data.
 * @author kamar baraka.*/


@Entity
@Data
public class Tickets implements DTOType {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private long ticketId;
    @Column(nullable = false)
    private String ticketName;
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tags tag;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Tasks> tasks;
    @Column(nullable = false)
    private LocalDate deadline;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status = TicketStatus.OPEN;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority = TicketPriority.MEDIUM;
    @Column(updatable = false, nullable = false)
    private final LocalDateTime createdOn = LocalDateTime.now();
    private LocalDateTime updatedOn = LocalDateTime.now();

}
