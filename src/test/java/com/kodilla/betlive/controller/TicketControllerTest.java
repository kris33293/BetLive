package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.service.TicketDbService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class TicketControllerTest {

    @Autowired
    TicketController ticketController;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    TicketDao ticketDao;

    @Test
    void getAllTickets() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");
        ticketDao.save(ticket);

        //When
        List<Ticket> tickets = ticketController.getAllTickets();

        //Then
        assertEquals(ticket.getTicketStatus(), tickets.get(0).getTicketStatus());

        //Cleanup
        ticketDao.delete(ticket);
    }

    @Test
    void getTicket() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");
        ticketDao.save(ticket);

        //When
        TicketDto tickets = ticketController.getTicket(ticket.getTicketId());

        //Then
        assertEquals(ticket.getTicketStatus(), tickets.getTicketStatus());

        //Cleanup
        ticketDao.delete(ticket);
    }

    @Test
    void getUserTicket() {
        //Given
        Ticket ticket = new Ticket();
        User user = new User();
        ticket.setUser(user);
        ticket.setTicketStatus("WIN");
        ticketDao.save(ticket);

        //When
        List<TicketDto> tickets = ticketController.getUserTicket(user.getUserId());

        //Then
        assertEquals(ticket.getTicketStatus(), tickets.get(0).getTicketStatus());

        //Cleanup
        ticketDao.delete(ticket);

    }

    @Test
    void checkTicketStatus() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");
        Type type = new Type();
        type.setYourType("HOME_WIN");
        List<Type> types = new ArrayList<>();
        types.add(type);
        ticket.setTypes(types);
        ticketDao.save(ticket);

        //When
        ticketController.checkTicketStatus(ticket.getTicketId());
        TicketDto tickets = ticketController.getTicket(ticket.getTicketId());
        //Then
        assertEquals("Pending", tickets.getTicketStatus());

        //Cleanup
        ticketDao.delete(ticket);
    }
}