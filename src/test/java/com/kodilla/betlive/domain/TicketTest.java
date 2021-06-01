package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class TicketTest {

    @Autowired
    TicketDao ticketDao;

    @Test
    void setTicketId() {
        //Given
        Ticket ticket = new Ticket();

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertNotEquals(0, newTicket.getTicketId());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setTypes() {
        //Given
        Ticket ticket = new Ticket();
        Type type = new Type();
        type.setHomeTeam("hometeam");
        List<Type> types = new ArrayList<>();
        types.add(type);
        ticket.setTypes(types);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("hometeam", ticket.getTypes().get(0).getHomeTeam());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setUser() {
        //Given
        Ticket ticket = new Ticket();
        User user = new User();
        user.setUserName("username");

        ticket.setUser(user);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("username", ticket.getUser().getUserName());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setTotalOdds() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTotalOdds(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getTotalOdds());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setTotalStake() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTotalStake(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getTotalStake());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setToWin() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setToWin(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getToWin());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setTicketStatus() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("WIN", newTicket.getTicketStatus());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void setBetslip() {
        //Given
        Ticket ticket = new Ticket();
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));

        ticket.setBetslip(betslip);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), ticket.getBetslip().getToWin());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getTicketId() {
        //Given
        Ticket ticket = new Ticket();

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertNotEquals(0, newTicket.getTicketId());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getTypes() {
        //Given
        Ticket ticket = new Ticket();
        Type type = new Type();
        type.setHomeTeam("hometeam");
        List<Type> types = new ArrayList<>();
        types.add(type);
        ticket.setTypes(types);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("hometeam", ticket.getTypes().get(0).getHomeTeam());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getUser() {
        //Given
        Ticket ticket = new Ticket();
        User user = new User();
        user.setUserName("username");

        ticket.setUser(user);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("username", ticket.getUser().getUserName());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getTotalOdds() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTotalOdds(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getTotalOdds());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getTotalStake() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTotalStake(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getTotalStake());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getToWin() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setToWin(new BigDecimal(200));

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), newTicket.getToWin());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getTicketStatus() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketStatus("WIN");

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals("WIN", newTicket.getTicketStatus());

        //Clean up
        ticketDao.delete(newTicket);
    }

    @Test
    void getBetslip() {
        //Given
        Ticket ticket = new Ticket();
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));

        ticket.setBetslip(betslip);

        //When
        Ticket newTicket = ticketDao.save(ticket);

        //Then
        assertEquals(new BigDecimal(200), ticket.getBetslip().getToWin());

        //Clean up
        ticketDao.delete(newTicket);
    }
}