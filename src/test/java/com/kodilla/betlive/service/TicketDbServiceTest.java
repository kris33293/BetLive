package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDao;
import com.kodilla.betlive.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class TicketDbServiceTest {

    @Autowired
    TicketDbService ticketDbService;

    @Autowired
    TicketDao ticketDao;

    @Test
    void createTicket() {
        //Given
        Ticket ticket = new Ticket();

        //When
        ticketDbService.createTicket(ticket);

        //Then
        assertNotEquals(0, ticket.getTicketId());

        //Clean up
        ticketDao.delete(ticket);
    }

    @Test
    void findByTicketId() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");
        ticketDbService.createTicket(ticket);

        //When
        Ticket foundTicket = ticketDbService.findByTicketId(ticket.getTicketId());

        //Then
        assertEquals(ticket.getTicketStatus(), foundTicket.getTicketStatus());

        //Clean up
        ticketDao.delete(ticket);
    }




}