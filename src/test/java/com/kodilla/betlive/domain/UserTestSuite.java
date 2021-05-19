package com.kodilla.betlive.domain;

import com.kodilla.betlive.controller.BetslipController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserTestSuite {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private BetslipDao betslipDao;

    @Test
    public void testAddNewUser() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(20.0));
        user.setUserName("username");

        //When
        userDao.save(user);

        //Then
        int id = user.getUserId();
        assertNotEquals(0, id);

        //CleanUp
        userDao.deleteById(id);
    }

    @Test
    public void testUserAndTicketRealtions() {
        //Given
        User user = new User();
        Ticket ticket = new Ticket();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        user.setBalance(new BigDecimal(20.0));
        user.setUserName("username");

        ticket.setUser(user);
        user.setTickets(tickets);

        //When
        userDao.save(user);
        ticketDao.save(ticket);

        //Then
        int userId = user.getUserId();
        int ticketUserId = ticket.getUser().getUserId();

        int ticketId = ticket.getTicketId();
        int userTicketId = user.getTickets().get(0).getTicketId();

        assertEquals(userId, ticketUserId);
        assertEquals(ticketId, userTicketId);

        //CleanUp
        userDao.deleteAll();
        ticketDao.deleteAll();

    }

    @Test
    public void testUserAndBetslipRealtions() {
        //Given
        User user = new User();

        Betslip betslip = new Betslip();

        betslip.setToWin(new BigDecimal(200.0));
        betslip.setTotalOdds(new BigDecimal(20.0));
        betslip.setTotalStake(new BigDecimal(10.0));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);

        user.setBalance(new BigDecimal(20.0));
        user.setUserName("username");

        betslip.setUser(user);
        user.setBetslips(betslips);

        //When
        userDao.save(user);
        betslipDao.save(betslip);

        //Then
        int userId = user.getUserId();
        int betslipUserId = betslip.getUser().getUserId();

        int betslipId = betslip.getBetslipId();
        int userBetslipId = user.getBetslips().get(0).getBetslipId();

        assertEquals(userId,betslipUserId);
        assertEquals(betslipId, userBetslipId);

        //CleanUp
        userDao.deleteAll();
        betslipDao.deleteAll();

    }

    @Test
    public void testUserAndBetslipRelationsAfterDeletingUser() {
        //Given
        User user = new User();
        Betslip betslip = new Betslip();

        betslip.setToWin(new BigDecimal(200.0));
        betslip.setTotalOdds(new BigDecimal(20.0));
        betslip.setTotalStake(new BigDecimal(10.0));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);

        user.setBalance(new BigDecimal(20.0));
        user.setUserName("username");

        betslip.setUser(user);
        user.setBetslips(betslips);

        //When
        userDao.save(user);
        betslipDao.save(betslip);
        int betslipId = betslip.getBetslipId();
        userDao.deleteById(user.getUserId());

        //Then
        assertFalse(betslipDao.existsById(betslipId));

        //Cleanuo
        betslipDao.deleteAll();
    }


    @Test
    public void testUserAndTicketRelationsAfterDeletingUser() {
        //Given
        User user = new User();
        Ticket ticket = new Ticket();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        user.setBalance(new BigDecimal(20.0));
        user.setUserName("username");

        ticket.setUser(user);
        user.setTickets(tickets);

        //When
        userDao.save(user);
        ticketDao.save(ticket);
        int ticketId = ticket.getTicketId();
        userDao.deleteById(user.getUserId());

        assertFalse(ticketDao.existsById(ticketId));

        ticketDao.deleteAll();
    }

}
