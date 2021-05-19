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

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TicketTestSuite {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private BetDao betDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TicketStatusDao ticketStatusDao;

    @Autowired
    private BetslipDao betslipDao;

    @Test
    public void testCreateTicket() {
        //Given
        Ticket ticket = new Ticket();
        ticket.setTicketId(1);
        ticket.setToWin(new BigDecimal(20.0));

        //When
        ticketDao.save(ticket);

        //Then
        int id = ticket.getTicketId();
        assertNotEquals(0, id);

        //CleanUp
        ticketDao.deleteAll();
    }

    @Test
    public void testTicketAndBetRealtions() {
        //Given
        Ticket ticket = new Ticket();
        Bet bet = new Bet();

        ticket.setTicketId(1);
        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        bet.setBetId(1);
        bet.setTickets(tickets);
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        ticket.setBets(bets);

        //When
        betDao.save(bet);
        ticketDao.save(ticket);

        //Then
        int ticketId = ticket.getTicketId();
        int ticketBetId = ticket.getBets().get(0).getBetId();

        int betId = bet.getBetId();
        int betTicketId = bet.getTickets().get(0).getTicketId();

        assertEquals(ticketId, ticketBetId);
        assertEquals(betId, betTicketId);

        //CleanUp
        betDao.deleteAll();
        ticketDao.deleteAll();

    }

    @Test
    public void testTicketAndUserRealtions() {
        //Given
        Ticket ticket = new Ticket();
        User user = new User();

        ticket.setTicketId(1);
        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        user.setUserId(1);
        user.setTickets(tickets);

        ticket.setUser(user);

        //When
        userDao.save(user);
        ticketDao.save(ticket);

        //Then
        int userId = user.getUserId();
        int ticketUserId = ticket.getUser().getUserId();

        int ticketId = ticket.getTicketId();
        int userTicketId = user.getTickets().get(0).getTicketId();

        assertEquals(userId,ticketUserId);
        assertEquals(ticketId,userTicketId);

        //CleanUp
        userDao.deleteAll();
        ticketDao.deleteAll();

    }

    @Test
    public void testTicketAndTicketStatusRealtions() {
        //Given
        Ticket ticket = new Ticket();
        TicketStatus ticketStatus = new TicketStatus();

        ticket.setTicketId(1);
        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        ticketStatus.setTicketStatusId(1);
        ticketStatus.setTickets(tickets);

        ticket.setTicketStatus(ticketStatus);

        //When
        ticketStatusDao.save(ticketStatus);
        ticketDao.save(ticket);

        //Then
        int ticketStatusId = ticketStatus.getTicketStatusId();
        int ticketStatusTicketId = ticketStatus.getTickets().get(0).getTicketId();

        int ticketId = ticket.getTicketId();
        int ticketTicketStatusId = ticket.getTicketStatus().getTicketStatusId();

        assertEquals(ticketStatusId,ticketStatusTicketId);
        assertEquals(ticketId,ticketTicketStatusId);

        //CleanUp
        ticketStatusDao.deleteAll();
        ticketDao.deleteAll();

    }

    @Test
    public void testTicketAndBetslipRealtions() {
        //Given
        Ticket ticket = new Ticket();
        Betslip betslip = new Betslip();
        User user = new User();

        user.setUserId(1);


        ticket.setTicketId(1);
        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        betslip.setBetslipId(1);
        betslip.setTicket(ticket);
        betslip.setToWin(new BigDecimal(200.0));
        betslip.setTotalOdds(new BigDecimal(20.0));
        betslip.setTotalStake(new BigDecimal(10.0));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);

        user.setBetslips(betslips);
        user.setTickets(tickets);
        ticket.setBetslip(betslip);

        //When
        ticketDao.save(ticket);
        betslipDao.save(betslip);

        //Then
        int betslipId = betslip.getBetslipId();
        int betslipTicketId = betslip.getTicket().getTicketId();

        int ticketId = ticket.getTicketId();
        int ticketBetslipId = ticket.getBetslip().getBetslipId();

        assertEquals(betslipId,betslipTicketId);
        assertEquals(ticketId,ticketBetslipId);



    }

    @Test
    public void testTicketAndBetRealtionsAfterDeletingTicket() {
        //Given
        Ticket ticket = new Ticket();
        Bet bet = new Bet();

        ticket.setTicketId(1);
        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        bet.setBetId(1);
        bet.setTickets(tickets);

        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        ticket.setBets(bets);

        //When

        ticketDao.save(ticket);
        betDao.save(bet);

        int betId = bet.getBetId();
        ticketDao.deleteAll();

        //Then
        assertFalse(betDao.existsById(betId));

        //CleanUp
        betDao.deleteAll();


    }

    @Test
    public void testTicketAndUserRealtionsAfterDeletingTicket() {
        //Given
        Ticket ticket = new Ticket();
        User user = new User();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        user.setTickets(tickets);

        ticket.setUser(user);

        //When
        userDao.save(user);
        ticketDao.save(ticket);

        int userId = user.getUserId();
        ticketDao.deleteAll();

        //Then
        assertTrue(userDao.existsById(userId));

        //CleanUp
        userDao.deleteAll();

    }

    @Test
    public void testTicketAndTicketStatusRealtionsAfterDeletingTicket() {
        //Given
        Ticket ticket = new Ticket();
        TicketStatus ticketStatus = new TicketStatus();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setTotalOdds(new BigDecimal(20.0));
        ticket.setTotalStake(new BigDecimal(10.0));
        ticket.setToWin(new BigDecimal(200.0));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        ticketStatus.setTickets(tickets);

        ticket.setTicketStatus(ticketStatus);

        //When
        ticketStatusDao.save(ticketStatus);
        ticketDao.save(ticket);

        int ticketStatusId = ticketStatus.getTicketStatusId();
        ticketDao.deleteAll();

        //Then
        assertTrue(ticketStatusDao.existsById(ticketStatusId));

        //CleanUp
        ticketStatusDao.deleteAll();
    }



}
