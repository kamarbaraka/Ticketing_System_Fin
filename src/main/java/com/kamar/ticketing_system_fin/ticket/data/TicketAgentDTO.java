package com.kamar.ticketing_system_fin.ticket.data;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;

/**
 * the ticket DTO for the admin.
 * @author kamar baraka.*/

@Schema(title = "Ticket Agent DTO",description = "an agent's view of the ticket", name = "TicketAgentDTO")
public record TicketAgentDTO(

        @SchemaProperty(name = "ticket name")
        String ticketName,
        @SchemaProperty(name = "description")
        String description,
        @SchemaProperty(name = "tag" )
        String tag,
        @SchemaProperty(name = "deadline")
        String deadline,
        @SchemaProperty(name = "status" )
        String status,
        @SchemaProperty(name = "priority" )
        String priority,
        @SchemaProperty(name = "updatedOn")
        String updatedOn
) implements DTOType{
}
