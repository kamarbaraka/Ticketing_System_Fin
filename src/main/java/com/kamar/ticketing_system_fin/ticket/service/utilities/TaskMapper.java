package com.kamar.ticketing_system_fin.ticket.service.utilities;

import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.data.TaskPresentationDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tasks;


/**
 * service to map tickets to DTOs.
 * @author kamar baraka.*/


public interface TaskMapper {

    Tasks mapToTask(TaskDTO taskDTO);
    TaskDTO mapToDTO(Tasks tasks);
    TaskPresentationDTO mapToPreDTO(Tasks tasks);
}
