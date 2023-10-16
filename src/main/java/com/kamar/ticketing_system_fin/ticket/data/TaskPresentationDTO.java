package com.kamar.ticketing_system_fin.ticket.data;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import org.hibernate.annotations.Type;

/**
 * the task presentation DTO.
 * @author kamar baraka.*/

@Schema(title = "Task Representation", name = "TaskPresentationDTO",description = "a representation of a task")
public record TaskPresentationDTO(

        @SchemaProperty(name = "description")
        String description,
        @SchemaProperty(name = "complete", schema = @Schema(implementation = Boolean.class))
        boolean complete
) implements DTOType{
}
