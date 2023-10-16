package com.kamar.ticketing_system_fin.ticket.service;


import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tasks;

/**
 * the task service.
 * @author kamar baraka.*/

public interface TaskService {

    Tasks createTaskGetTask(TaskDTO taskDTO);

    void updateTaskById(long taskId, TaskDTO taskDTO);

    void deleteTaskById(long taskId);
}
