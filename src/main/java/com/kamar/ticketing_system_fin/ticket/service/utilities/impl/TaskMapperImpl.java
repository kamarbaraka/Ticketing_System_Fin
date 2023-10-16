package com.kamar.ticketing_system_fin.ticket.service.utilities.impl;

import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.data.TaskPresentationDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tasks;
import com.kamar.ticketing_system_fin.ticket.service.utilities.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * implementation of the task mapper.
 * @author kamar baraka.*/

@Service
@RequiredArgsConstructor
public class TaskMapperImpl implements TaskMapper {

    /*inject the ModelMapper*/
    private final ModelMapper mapper;

    /**
     * map {@link TaskDTO} to {@link Tasks}*/
    @Override
    public Tasks mapToTask(TaskDTO taskDTO) {

        /*map TaskDTO to Tasks*/
        return mapper.map(taskDTO, Tasks.class);
    }

    /**
     * map {@link Tasks} to {@link TaskDTO}*/
    @Override
    public TaskDTO mapToDTO(Tasks tasks) {

        return mapper.map(tasks, TaskDTO.class);
    }

    /**
     * map {@link Tasks} to {@link TaskPresentationDTO}*/
    @Override
    public TaskPresentationDTO mapToPreDTO(Tasks tasks) {

        return mapper.map(tasks, TaskPresentationDTO.class);
    }
}
