package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class BetTestSuite {

    @Autowired
    private BetDao betDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private BetslipDao betslipDao;

    @Test
    public void testCreateBet() {
        //Given
        Bet bet = new Bet();

        betDao.save(bet);

        //Then
        int id = bet.getBetId();
        assertNotEquals(0, id);

        //CleanU
        betDao.deleteById(id);
    }

    @Test
    public void testBetAndTicketRelations(){
        //Given
        Bet bet = new Bet();
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);
        Ticket ticket = new Ticket();
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        bet.setTickets(tickets);
        ticket.setBets(bets);

        //When
        betDao.save(bet);
        ticketDao.save(ticket);

        //Then
        int betId = bet.getBetId();
        int ticketBetId = ticket.getBets().get(0).getBetId();

        int ticketId = ticket.getTicketId();
        int betTicketId = bet.getTickets().get(0).getTicketId();

        assertEquals(betId, ticketBetId);
        assertEquals(ticketId, betTicketId);

        //Cleanup
        betDao.deleteAll();
        ticketDao.deleteAll();
    }

    @Test
    public void testBetAndBetslipRelations(){
        //Given
        Bet bet = new Bet();
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        Betslip betslip = new Betslip();
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);

        bet.setBetslips(betslips);
        betslip.setBets(bets);

        //When
        betDao.save(bet);
        betslipDao.save(betslip);

        //Then
        int betId = bet.getBetId();
        int betBetslipId = betslip.getBets().get(0).getBetId();

        int betslipId = betslip.getBetslipId();
        int betslipBetId = bet.getBetslips().get(0).getBetslipId();

        assertEquals(betId, betBetslipId);
        assertEquals(betslipId, betslipBetId);

        //Cleanup
        betDao.deleteAll();
        betslipDao.deleteAll();
    }

    @Test
    public void testBetAndTicketRelationsAfterDeletingBet(){
        //Given
        Bet bet = new Bet();
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);
        Ticket ticket = new Ticket();
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);

        bet.setTickets(tickets);
        ticket.setBets(bets);

        betDao.save(bet);
        ticketDao.save(ticket);

        //When
        int ticketId = ticket.getTicketId();
        betDao.deleteById(bet.getBetId());
        assertTrue(ticketDao.existsById(ticketId));

        //Cleanup
        ticketDao.deleteAll();
    }

    @Test
    public void testBetAndBetslipRelationsAfterDeletingBet(){
        //Given
        Bet bet = new Bet();
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        Betslip betslip = new Betslip();
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);

        bet.setBetslips(betslips);
        betslip.setBets(bets);

        betDao.save(bet);
        betslipDao.save(betslip);

        //Then
        int betslipId = betslip.getBetslipId();
        betDao.deleteById(bet.getBetId());
        assertTrue(betslipDao.existsById(betslipId));

        //Cleanup
        betDao.deleteAll();

    }

}
