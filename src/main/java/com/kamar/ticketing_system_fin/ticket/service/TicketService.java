package com.kamar.ticketing_system_fin.ticket.service;


import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;

import java.util.List;

public interface TicketService {

    Tickets createTicket(TicketDTO ticketDTO);
    List<Tickets> getAllTickets();
    List<Tickets> getOpenTickets();
    List<Tickets> getClosedTickets();
    List<Tickets> getResolvedTickets();
    List<Tickets> getInProgressTickets();
    Tickets getTicketByTicketId(long ticketId);
    List<Tickets> getTicketByName(String ticketName);
    List<Tickets> getTicketsByTag(String tag);
    void updateTicketById(long ticketId, TicketDTO ticketDTO);
    void deleteTicketById(long ticketId);
    void addTaskToTicket(long ticketId, TaskDTO taskDTO);
    void deleteTaskFromTicket(long ticketId, long taskId);
    void completeTaskOfTicket(long ticketId, long taskId);

}
