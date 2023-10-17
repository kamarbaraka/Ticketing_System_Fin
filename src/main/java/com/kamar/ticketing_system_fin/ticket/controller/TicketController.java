package com.kamar.ticketing_system_fin.ticket.controller;

import com.kamar.ticketing_system_fin.ticket.data.*;
import com.kamar.ticketing_system_fin.ticket.entity.Tickets;
import com.kamar.ticketing_system_fin.ticket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * the ticket controller.
 * @author kamar baraka.*/

@Log4j2
@RestController
@RequestMapping(value = {"/api/v1/tickets"})
@RequiredArgsConstructor
@Tag(name = "Ticket Api", description = "the ticket API exposing ticket operations")
public class TicketController {

    /*inject dependencies*/
    private final TaskMapper taskMapper;
    private final TicketMapper ticketMapper;
    private final TicketService ticketService;

    @GetMapping
    @Parameter(name = "user role")
    @Operation(tags = {"Ticket Api"},summary = "get all tickets",description = "get all tickets in the database")
    public ResponseEntity<List<? extends EntityModel<? extends DTOType>>> getAllTickets(@RequestHeader(value = "ROLE", defaultValue = "USER")
                                                                                  String  userRole){

        /*get all tickets*/
        List<Tickets> allTickets = ticketService.getAllTickets();
        List<Long> listIds = allTickets.stream().map(Tickets::getTicketId).toList();
        List<? extends DTOType> allTicketsDTO;
        /*get DTO based on roles*/
        switch (userRole){
            case "AGENT" -> allTicketsDTO = allTickets.stream().map(ticketMapper::mapToAgentDTO).toList();
            case "ADMIN" -> allTicketsDTO = allTickets;
            case "USER" -> allTicketsDTO = allTickets.stream().map(ticketMapper::mapToNormalDTO).toList();
            default -> allTicketsDTO = null;

        }

        assert allTicketsDTO != null;
        final int[] index = {0};
        /*create the Entity model*/
        List<? extends EntityModel<? extends DTOType>> entityModels = allTicketsDTO.stream().map(EntityModel::of).toList();
        /*add links*/
        entityModels = entityModels.stream().peek(entity ->
        {

            entity.add(WebMvcLinkBuilder.linkTo(TicketController.class).
                    slash("byId").slash(listIds.get(index[0])).withRel("ticket_details"));
            index[0]++;
        }).toList();

        /*create and return a response*/
        return ResponseEntity.ok(entityModels);

    }

    @GetMapping(value = {"byName/{name}"})
    @Operation(summary = "get ticket", description = "get ticket by name")
    public ResponseEntity<EntityModel<? extends List<? extends DTOType>>> getTicketByName(@RequestHeader(name = "ROLE", defaultValue = "USER") String userRole ,
                                                                                          @PathVariable("name") String name){

        /*get ticket by name*/
        List<Tickets> ticketByName = ticketService.getTicketByName(name);
        /*declare a ticket*/
        List<? extends DTOType> tickets;
        /*get DTO based on a role*/
        switch (userRole){
            case "USER" -> tickets = ticketByName.stream().map(ticketMapper::mapToNormalDTO).toList();
            case "ADMIN" -> tickets = ticketByName;
            case "AGENT" -> tickets = ticketByName.stream().map(ticketMapper::mapToAgentDTO).toList();
            default -> tickets = null;
        }

        assert tickets != null;
        /*create an entity model*/
        EntityModel<? extends List<? extends DTOType>> listEntityModel = EntityModel.of(tickets);

        /*return the response*/
        return ResponseEntity.ok(listEntityModel);

    }

    @GetMapping(value = {"byId/{ticketId}"})
    @Operation(summary = "get ticket", description = "get a ticket by ID")
    public ResponseEntity<EntityModel<DTOType>> getTicketById(@RequestHeader(name = "ROLE", defaultValue = "USER")
                                                              String userRole, @PathVariable("ticketId")
                                                              long ticketId){

        /*get a ticket by the ID*/
        Tickets ticketByTicketId = ticketService.getTicketByTicketId(ticketId);
        DTOType ticketDTO;
        /*get DTO based on the role*/
        switch (userRole){

            case "USER" -> ticketDTO = ticketByTicketId;
            case "AGENT" -> ticketDTO = ticketByTicketId;
            case "ADMIN" -> ticketDTO = ticketByTicketId;
            default -> ticketDTO = null;
        }
        assert ticketDTO != null;
        /*create an entity model*/
        EntityModel<DTOType> dtoType = EntityModel.of(ticketByTicketId);
        /*add a link*/


        /*return the response*/
        return ResponseEntity.ok(dtoType);
    }

    /**
     * create ticket
     */
    @PostMapping
    @Operation(tags = {"Ticket Api"},summary = "create ticket",description = "create a ticket" )
    public ResponseEntity<EntityModel<CreatedDTO>> createTicket(@Validated @RequestBody final TicketDTO ticketDTO){

        /*create the ticket*/
        Tickets ticket = ticketService.createTicket(ticketDTO);

        /*create the response*/
        EntityModel<CreatedDTO> response = EntityModel.of(new CreatedDTO("successfully Created"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TicketController.class).getTicketById(
                        "USER", ticket.getTicketId()
                )).withRel("the ticket")
        );

        return ResponseEntity.status(201).body(response);
    }

    @PostMapping(value = {"task/{id}"})
    public ResponseEntity<EntityModel<DTOType>> addTaskToTicket(@PathVariable("id") final long ticketId ,
                                                                @RequestBody TaskDTO task){
        log.warn("passed {}", task);

        /*create the task*/
        ticketService.addTaskToTicket(ticketId, task);
        /*create the response*/
        EntityModel<DTOType> response = EntityModel.of(new CreatedDTO("task added successfully. click the link to see"));
        /*create links*/
        Link ticketLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TicketController.class).
                getTicketById("USER", ticketId)).withRel("ticket");

        /*add links*/
        response.add(ticketLink);

        log.warn("created {}", task);

        /*create response*/
        return ResponseEntity.status(201).body(response);
    }
}
