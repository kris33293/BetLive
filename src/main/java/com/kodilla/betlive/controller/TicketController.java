package com.kodilla.betlive.controller;


import com.kodilla.betlive.client.CheckStatusClient;
import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDto;
import com.kodilla.betlive.mapper.TicketMapper;

import com.kodilla.betlive.service.ResultDbService;
import com.kodilla.betlive.service.TicketDbService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/tickets")
public class TicketController {

    public final TicketMapper ticketMapper;
    public final TicketDbService ticketDbService;
    public final ResultDbService resultDbService;

    @RequestMapping(method = RequestMethod.GET, value = "getALlTickets")
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketDbService.findAllTickets();
        return ticketMapper.maptoTicketDtoList(tickets);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTicket")
    public TicketDto getTicket(@RequestParam int ticketId) {
        return ticketMapper.mapToTicketDto(ticketDbService.findByTicketId(ticketId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTicket")
    public void deleteTicket(@RequestParam int ticketId) {
        ticketDbService.deleteTicket(ticketId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserTickets")
    public List<TicketDto> getUserTicket(@RequestParam int userId) {
        List<Ticket> tickets = ticketDbService.findTicketsByUserId(userId);
        return ticketMapper.maptoTicketDtoList(tickets);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "checkTicketStatus")
    public void checkTicketStatus(@RequestParam int ticketId) {
        Ticket ticket = ticketDbService.findByTicketId(ticketId);
        List<Result> results = resultDbService.findAll();
        CheckStatusClient checkStatusClient = new CheckStatusClient();
        Ticket checkedTicket = checkStatusClient.checkTicket(ticket, results);
        ticketDbService.createTicket(checkedTicket);
        System.out.println("Ticket checked");
    }
}
