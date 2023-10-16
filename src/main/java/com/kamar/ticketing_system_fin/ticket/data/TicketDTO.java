package com.kamar.ticketing_system_fin.ticket.data;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;

/**
 * the ticket DTO.
 * @author kamar baraka.*/

@Schema(title = "Ticket DTO",description = "schema to create a ticket", name = "TicketDTO")
public record TicketDTO(

        @SchemaProperty(name = "ticket name")
        String ticketName,
        @SchemaProperty(name = "description")
        String description,
        @SchemaProperty(name = "tag")
        String tag,
        @SchemaProperty(name = "deadline")
        String deadline
) implements DTOType{
}
