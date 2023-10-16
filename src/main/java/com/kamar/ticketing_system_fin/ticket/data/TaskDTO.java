package com.kamar.ticketing_system_fin.ticket.data;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;

/**
 * the task DTO.
 * @author kamar baraka.*/

@Schema(title = "Task DTO",name = "TaskDTO",description = "the schema to create tasks")
public record TaskDTO (
        @SchemaProperty(name = "description") String description
) implements DTOType {

    @Override
    public String description() {
        return description;
    }
}
