package com.kamar.ticketing_system_fin.ticket.service.utilities.impl;

import com.kamar.ticketing_system_fin.ticket.data.TicketAgentDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketNormalDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;
import com.kamar.ticketing_system_fin.ticket.service.utilities.TicketMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * implementation of the ticket mapper.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class TicketMapperImpl implements TicketMapper {

    /*inject the mapper*/
    private final ModelMapper mapper;

    /**
     * map {@link TicketDTO} to {@link Tickets}*/
    @Override
    public Tickets mapToTicket(TicketDTO ticketDTO) {

        return mapper.map(ticketDTO, Tickets.class);
    }

    /**
     * map {@link Tickets} to {@link TicketDTO}*/
    @Override
    public TicketDTO mapToDTO(Tickets tickets) {

        return mapper.map(tickets, TicketDTO.class);
    }

    /**
     * map {@link Tickets} to {@link TicketNormalDTO}*/
    @Override
    public TicketNormalDTO mapToNormalDTO(Tickets tickets) {

        return mapper.map(tickets, TicketNormalDTO.class);
    }

    /**
     * map {@link Tickets} to {@link TicketAgentDTO}*/
    @Override
    public TicketAgentDTO mapToAgentDTO(Tickets tickets) {

        return mapper.map(tickets, TicketAgentDTO.class);
    }
}
