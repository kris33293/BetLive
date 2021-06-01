package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TicketDbService {

    @Autowired
    private final TicketDao ticketDao;

    public Ticket createTicket(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    public Ticket findByTicketId(int ticketId) {
        return ticketDao.findByTicketId(ticketId);
    }

    public Set<Ticket> findTicketsByUserId(int userId) {
        return ticketDao.findByUserUserId(userId);
    }

    public Set<Ticket> findAllTickets() {
        return ticketDao.findAll();
    }

    public void deleteTicket(int ticketId) { ticketDao.deleteById(ticketId);}

}
