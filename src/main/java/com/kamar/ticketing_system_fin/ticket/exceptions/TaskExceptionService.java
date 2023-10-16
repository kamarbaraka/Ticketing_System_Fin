package com.kamar.ticketing_system_fin.ticket.exceptions;

/**
 * ticket exception service.
 * @author kamar baraka.*/

public interface TaskExceptionService {

    TicketNotFoundException ticketNotFound();
    TaskNotFoundException taskNotFound();
}
