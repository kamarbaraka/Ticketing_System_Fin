package com.kamar.ticketing_system_fin.ticket.service.utilities;

import com.kamar.ticketing_system_fin.ticket.data.TicketAgentDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketNormalDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;

/**
 * service to map tickets to DTOs.
 * @author kamar baraka.*/

public interface TicketMapper {

    Tickets mapToTicket(TicketDTO ticketDTO);
    TicketDTO mapToDTO(Tickets tickets);
    TicketNormalDTO mapToNormalDTO(Tickets tickets);
    TicketAgentDTO mapToAgentDTO(Tickets tickets);
}
