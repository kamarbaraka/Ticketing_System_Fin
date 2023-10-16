package com.kamar.ticketing_system_fin.ticket.service.implementations;

import com.kamar.ticketing_system_fin.ticket.data.TaskDTO;
import com.kamar.ticketing_system_fin.ticket.data.TicketDTO;
import com.kamar.ticketing_system_fin.ticket.entity.Tags;
import com.kamar.ticketing_system_fin.ticket.entity.Tasks;
import com.kamar.ticketing_system_fin.ticket.entity.TicketStatus;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;
import com.kamar.ticketing_system_fin.ticket.exceptions.TaskExceptionService;
import com.kamar.ticketing_system_fin.ticket.repository.TicketsRepository;
import com.kamar.ticketing_system_fin.ticket.service.TaskService;
import com.kamar.ticketing_system_fin.ticket.service.TicketService;
import com.kamar.ticketing_system_fin.ticket.service.utilities.TicketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * the ticket service implementation.
 * @author kamar baraka.*/

@Log4j2
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TaskExceptionService taskException;
    private final TaskService taskService;
    private final TicketsRepository ticketsRepository;
    private final TicketMapper ticketMapper;

    public List<Tickets> getOpenTickets(){

        /*get all open tickets*/
        return ticketsRepository.findAll(
                Sort.by(Sort.Direction.DESC, "ticket_priority")
        ).stream().filter(tickets -> tickets.getStatus() == TicketStatus.OPEN).toList();
    }
    public List<Tickets> getClosedTickets(){

        /*get closed tickets*/
        return ticketsRepository.findAllByStatus(
                TicketStatus.CLOSED);
    }
    public List<Tickets> getResolvedTickets(){

        /*get resolved tickets*/
        return ticketsRepository.findAllByStatus(
                TicketStatus.RESOLVED
        );
    }
    public List<Tickets> getInProgressTickets(){

        /*get the in-progress tickets*/
        return ticketsRepository.findAllByStatus(
                TicketStatus.IN_PROGRESS
        );
    }

    @Override
    public Tickets createTicket(@Validated TicketDTO ticketDTO) {

        /*map the ticket to DTO*/
        Tickets ticket = ticketMapper.mapToTicket(ticketDTO);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate deadline = LocalDate.parse(ticketDTO.deadline(), formatter);
        ticket.setDeadline(deadline);

        ticket.setTag(Tags.valueOf(ticketDTO.tag()));
        ticket.setTicketName(ticketDTO.ticketName());

        ticket.setDescription(ticketDTO.description());
        /*persist the ticket*/
        return ticketsRepository.save(ticket);
    }

    @Override
    public List<Tickets> getAllTickets() {

        /*get all tickets*/
        return ticketsRepository.findAll(
                Sort.by(Sort.Direction.DESC, "priority")
        );

    }

    @Override
    public Tickets getTicketByTicketId(final long ticketId) {

        /*get a ticket by ID*/
        return ticketsRepository.findById(ticketId).orElseThrow(taskException::ticketNotFound);

    }

    @Override
    public List<Tickets> getTicketByName(final String ticketName) {

        /*get ticket by name*/
        return ticketsRepository.findTicketsByTicketName(ticketName);
    }

    @Override
    public List<Tickets> getTicketsByTag(final String tag) {

        /*find tickets by the tag*/
        return ticketsRepository.findAllByTag(Tags.valueOf(tag));
    }

    @Override
    public void updateTicketById(final long ticketId,@Validated final TicketDTO ticketDTO) {

        /*check if the ticket exists*/
        ticketsRepository.findById(ticketId).ifPresentOrElse(
                ticket -> {
                    Tickets ticketToSave = ticketMapper.mapToTicket(ticketDTO);
                    ticketToSave.setTicketId(ticket.getTicketId());
                    ticketsRepository.save(ticketToSave);
                },
                taskException::ticketNotFound
        );
    }

    @Override
    public void deleteTicketById(final long ticketId) {

        /*check if exists and delete ticket with the id*/
        ticketsRepository.findById(ticketId).ifPresentOrElse(
                ticket -> ticketsRepository.deleteById(ticketId),
                taskException::ticketNotFound
        );
    }

    @Override
    public void addTaskToTicket(final long ticketId,@Validated final TaskDTO taskDTO) {

        log.warn("service entry {}", taskDTO);

        /*check if ticket exists*/
        ticketsRepository.findById(ticketId).ifPresentOrElse(
                ticket -> {
                    /*create the task*/
                    Tasks task = taskService.createTaskGetTask(taskDTO);
                    /*add the task to the ticket*/
                    ticket.getTasks().add(task);
                    /*update the ticket*/
                    ticketsRepository.save(ticket);
                },
                taskException::ticketNotFound
        );

        log.warn("service pass {}", taskDTO);

    }

    @Override
    public void deleteTaskFromTicket(final long ticketId,final long taskId) {

        /*check if ticket exists*/
        ticketsRepository.findById(ticketId).ifPresentOrElse(
                ticket -> taskService.deleteTaskById(taskId),
                taskException::taskNotFound
        );
    }

    @Override
    public void completeTaskOfTicket(final long ticketId,final long taskId) {

        /*check if the ticket exists*/
        ticketsRepository.findById(ticketId).ifPresentOrElse(
                ticket -> {
                    /*get the ticket with the id and update*/
                    List<Tasks> updatedTasks = ticket.getTasks().stream().filter(task -> task.getTaskId() == taskId).peek(
                            task -> task.setComplete(true)
                    ).toList();
                    /*update the task on the ticket*/
                    ticket.getTasks().addAll(updatedTasks);
                    ticketsRepository.save(ticket);
                },
                taskException::ticketNotFound
        );
    }
}
