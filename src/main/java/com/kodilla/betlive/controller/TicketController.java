package com.kodilla.betlive.controller;


import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDto;
import com.kodilla.betlive.domain.TicketStatusDto;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.mapper.TicketStatusMapper;
import com.kodilla.betlive.service.TicketDbService;
import com.kodilla.betlive.service.TicketStatusDbService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/ticket")
public class TicketController {

    public final TicketMapper ticketMapper;
    public final TicketStatusMapper ticketStatusMapper;
    public final TicketDbService ticketDbService;
    public final TicketStatusDbService ticketStatusDbService;


    @RequestMapping(method = RequestMethod.GET, value = "getALlTickets")
    public List<TicketDto> getAllTickets(){
        List<Ticket> tickets = ticketDbService.findAllTickets();
        return ticketMapper.maptoTicketDtoList(tickets);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTicket")
    public TicketDto getTicket(int ticketId) {
        return ticketMapper.mapToTicketDto(ticketDbService.findByTicketId(ticketId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserTickets")
    public List<TicketDto> getUserTicket(int userId) {
        List<Ticket> tickets = ticketDbService.findTicketsByUserId(userId);
        return ticketMapper.maptoTicketDtoList(tickets);
    }

    @RequestMapping(method = RequestMethod.GET, value = "checkTicketStatus")
    public TicketStatusDto checkTicketStatus(int ticketId) {
        return new TicketStatusDto();
    }
}
