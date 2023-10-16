package com.kamar.ticketing_system_fin.ticket.repository;

import com.kamar.ticketing_system_fin.ticket.entity.Tags;
import com.kamar.ticketing_system_fin.ticket.entity.TicketStatus;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * tickets repository.
 * @author kamar baraka.*/


@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {

    List<Tickets> findAllByStatus(TicketStatus status);
    List<Tickets> findTicketsByTicketName(String ticketName);
    List<Tickets> findAllByTag(Tags tag);
}
