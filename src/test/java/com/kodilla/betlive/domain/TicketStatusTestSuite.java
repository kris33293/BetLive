package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TicketStatusTestSuite {

    @Autowired
    private TicketStatusDao ticketStatusDao;

    @Autowired
    private TicketDao ticketDao;

    @Test
    public void testCreateTicketStatus(){
        //Given
        TicketStatus ticketStatus = new TicketStatus();

        //When
        ticketStatusDao.save(ticketStatus);

        //Then
        int id = ticketStatus.getTicketStatusId();
        assertNotEquals(0, id);

        //Cleanup
        ticketStatusDao.deleteById(id);
    }

    @Test
    public void testTicketStatusAndTicketRealtions(){
        //Given
        TicketStatus ticketStatus = new TicketStatus();
        Ticket ticket = new Ticket();
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        ticketStatus.setTickets(tickets);
        ticket.setTicketStatus(ticketStatus);

        //When
        ticketStatusDao.save(ticketStatus);
        ticketDao.save(ticket);

        //Then
        int ticketStatusId = ticketStatus.getTicketStatusId();
        int ticketStatusTicketId = ticket.getTicketStatus().getTicketStatusId();

        int ticketId = ticket.getTicketId();
        int ticketTicketStatusId = ticketStatus.getTickets().get(0).getTicketId();

        assertEquals(ticketId,ticketTicketStatusId);
        assertEquals(ticketStatusId,ticketStatusTicketId);

        //Cleanup
        ticketStatusDao.deleteAll();
        ticketDao.deleteAll();
    }

    @Test
    public void testTicketStatusAndTicketRealtionsAfterDeletingTicketStatus(){
        //Given
        TicketStatus ticketStatus = new TicketStatus();
        Ticket ticket = new Ticket();
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        ticketStatus.setTickets(tickets);
        ticket.setTicketStatus(ticketStatus);

        ticketStatusDao.save(ticketStatus);
        ticketDao.save(ticket);

        //Then
        int ticketId = ticket.getTicketId();
        ticketStatusDao.deleteById(ticketStatus.getTicketStatusId());
        assertTrue(ticketDao.existsById(ticketId));

        //Cleanup
        ticketStatusDao.deleteAll();
        ticketDao.deleteAll();
    }
}
