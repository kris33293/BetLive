package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TicketDbService {

    private final TicketDao ticketDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    public Ticket findByTicketId(int ticketId) {
        return ticketDao.findByTicketId(ticketId);
    }

    public List<Ticket> findTicketsByUserId(int userId) {
        return ticketDao.findByUserUserId(userId);
    }

    public List<Ticket> findAllTickets() {
        return ticketDao.findAll();
    }

}
