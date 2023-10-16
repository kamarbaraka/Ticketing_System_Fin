package com.kamar.ticketing_system_fin.ticket.data;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;

/**
 * normal ticket DTO.
 * @author kamar baraka.*/

@Schema(title = "Ticket normal DTO",name = "TicketNormalDTO",description = "a representation of a ticket to a normal user")
public record TicketNormalDTO(

        @SchemaProperty(name = "ticket name")
        String ticketName,
        @SchemaProperty(name = "description")
        String description,
        @SchemaProperty(name = "tag")
        String tag,
        @SchemaProperty(name = "status")
        String status,
        @SchemaProperty(name = "created on")
        String createdOn
) implements DTOType{

}
