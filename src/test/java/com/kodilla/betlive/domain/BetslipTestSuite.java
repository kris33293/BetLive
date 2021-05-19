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
public class BetslipTestSuite {

    @Autowired
    private BetslipDao betslipDao;

    @Autowired
    private BetDao betDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void testCreateBetslip() {
        //Given
        Betslip betslip = new Betslip();


        betslipDao.save(betslip);

        //Then
        int id = betslip.getBetslipId();
        assertNotEquals(0, id);

        //CleanUp
        betslipDao.deleteById(id);
    }


    @Test
    public void testBetslipAndBetRealtions() {
        //Given
        Betslip betslip = new Betslip();
        Bet bet = new Bet();

        List<Bet> bets = new ArrayList<>();

        betslip.setBets(bets);
        List<Betslip> betslips  = new ArrayList<>();
        betslips.add(betslip);
        bet.setBetslips(betslips);
        bets.add(bet);


        //When
        betDao.save(bet);
        betslipDao.save(betslip);

        //Then
        int betslipId = betslip.getBetslipId();
        int betslipBetId = betslip.getBets().get(0).getBetId();

        int betId = bet.getBetId();
        int betBetslipId = bet.getBetslips().get(0).getBetslipId();

        assertEquals(betslipId, betBetslipId);
        assertEquals(betId, betslipBetId);

        //CleanUp
        betDao.deleteAll();
        betslipDao.deleteById(betslipId);

    }

    @Test
    public void testBetslipAndUserRealtions() {
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
    public void testBetslipAndTicketRealtions() {
        //Given
        Betslip betslip = new Betslip();
        Ticket ticket = new Ticket();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setUser(new User());
        ticket.setBets(new ArrayList<>());

        betslip.setUser(new User());
        betslip.setBets(new ArrayList<>());
        betslip.setTicket(ticket);
        ticket.setBetslip(betslip);


        //When
        betslipDao.save(betslip);
        ticketDao.save(ticket);


        //Then
        int betslipId = betslip.getBetslipId();
        int betslipTicketId = betslip.getTicket().getTicketId();

        int ticketId = ticket.getTicketId();
        int ticketBetslipId = ticket.getBetslip().getBetslipId();

        assertEquals(betslipId, ticketBetslipId);
        assertEquals(ticketId, betslipTicketId);

        //CleanUp

        ticketDao.deleteAll();
        betslipDao.deleteAll();
    }

    @Test
    public void testBetslipAndTicketRealtionsAfterDeletingBetslip() {
        //Given
        Betslip betslip = new Betslip();
        Ticket ticket = new Ticket();

        ticket.setTicketStatus(new TicketStatus());
        ticket.setUser(new User());
        ticket.setBets(new ArrayList<>());

        betslip.setUser(new User());
        betslip.setBets(new ArrayList<>());
        betslip.setTicket(ticket);
        ticket.setBetslip(betslip);


        //When
        betslipDao.save(betslip);
        ticketDao.save(ticket);

        int ticketId = ticket.getTicketId();
        betslipDao.deleteById(betslip.getBetslipId());

        //Then
        assertTrue(ticketDao.existsById(ticketId));

        //CleanUp
        ticketDao.deleteAll();
    }

    @Test
    public void testBetslipAndUserRealtionsAfterDeletingBetslip() {
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

        int userId = user.getUserId();
        betslipDao.deleteById(betslip.getBetslipId());

        //Then
        assertTrue(userDao.existsById(userId));

        //CleanUp
        userDao.deleteAll();

    }

    @Test
    public void testBetslipAndBetRealtionsAfterDeletingBetslip() {
        //Given
        Betslip betslip = new Betslip();
        Bet bet = new Bet();

        List<Bet> bets = new ArrayList<>();


        betslip.setBets(bets);
        List<Betslip> betslips  = new ArrayList<>();
        betslips.add(betslip);
        bet.setBetslips(betslips);
        bets.add(bet);


        //When
        betDao.save(bet);
        betslipDao.save(betslip);

        int betId = bet.getBetId();
        betslipDao.deleteById(betslip.getBetslipId());

        //Then
        assertTrue(betDao.existsById(betId));

        //CleanUp
        betDao.deleteAll();


    }

}
