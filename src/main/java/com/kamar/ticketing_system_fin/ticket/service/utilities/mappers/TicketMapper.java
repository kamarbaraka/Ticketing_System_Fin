package com.kamar.ticketing_system_fin.ticket.service.utilities.mappers;

import com.kamar.ticketing_system_fin.ticket.data.TicketDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketNormalDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tags;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * the tsk mapping utilities.
 * @author kamar baraka.*/

@Mapper
public interface TicketMapper {

    /**
     * map {@link TicketDTO} to {@link Tickets}*/
    @Mapping(source = "ticketName", target = "ticketName")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "tag", target = "tag", expression = "mapTag")
    @Mapping(source = "deadline", target = "deadline", dateFormat = "dd/MM/yyyy")
    Tickets mapToTickets(TicketDTO ticketDTO);

    default Tags mapTag(String tag){
        /*return the mapping*/
        return Tags.valueOf(tag);
    }

}


