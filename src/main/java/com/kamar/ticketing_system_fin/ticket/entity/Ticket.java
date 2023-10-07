package com.kamar.ticketing_system_fin.ticket.entity;

import com.kamar.ticketing_system_fin.ticket.data.UserData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * the ticket entity to cary ticket data.
 * @author kamar baraka.*/

@Entity
public class Ticket {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID ticketID;
    private String theIssue;
}
