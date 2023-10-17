package com.kamar.ticketing_system_fin.ticket.service.utilities.mappers;

import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tasks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * task mapping utilities.
 * @author kamar baraka.*/

@Mapper
public interface TaskMapper {

    @Mapping(source = "description", target = "description")
    Tasks mapToTask(TaskDTO taskDTO);
}
