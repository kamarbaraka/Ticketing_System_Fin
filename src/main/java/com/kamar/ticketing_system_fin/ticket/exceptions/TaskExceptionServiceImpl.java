package com.kamar.ticketing_system_fin.ticket.exceptions;

import org.springframework.stereotype.Component;

/**
 * implementation of the task exception service.
 * @author kamar baraka.*/

@Component
public class TaskExceptionServiceImpl implements TaskExceptionService {
    @Override
    public TicketNotFoundException ticketNotFound() {
        /*return an instance of exception*/
        return new TicketNotFoundException("no such ticket");
    }

    @Override
    public TaskNotFoundException taskNotFound() {
        /*return an instance*/
        return new TaskNotFoundException("no such task");
    }
}
