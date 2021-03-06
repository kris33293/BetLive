package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class UserTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private BetslipDao betslipDao;


    @Test
    void setUserId() {
        //Given
        User user = new User();

        //When
        User newUser = userDao.save(user);

        //Then
        assertNotEquals(0, newUser.getUserId());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void setUserName() {
        //Given
        User user = new User();
        user.setUserName("username");
        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals("username", newUser.getUserName());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void setBalance() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(200));
        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals(new BigDecimal(200), newUser.getBalance());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void setTickets() {
        //Given
        User user = new User();

        Ticket ticket = new Ticket();
        ticket.setTicketStatus("checked");

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        user.setTickets(ticketList);


        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals("checked", newUser.getTickets().get(0).getTicketStatus());

        //Cleanup
        userDao.delete(newUser);

    }

    @Test
    void setBetslips() {
        //Given
        User user = new User();

        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));

        List<Betslip> betslipList = new ArrayList<>();
        betslipList.add(betslip);

        user.setBetslips(betslipList);


        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals(new BigDecimal(200), newUser.getBetslips().get(0).getToWin());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void getUserId() {
        //Given
        User user = new User();

        //When
        User newUser = userDao.save(user);

        //Then
        assertNotEquals(0, newUser.getUserId());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void getUserName() {
        //Given
        User user = new User();
        user.setUserName("username");
        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals("username", newUser.getUserName());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void getBalance() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(200));
        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals(new BigDecimal(200), newUser.getBalance());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void getTickets() {
        //Given
        User user = new User();

        Ticket ticket = new Ticket();
        ticket.setTicketStatus("checked");

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        user.setTickets(ticketList);


        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals("checked", newUser.getTickets().get(0).getTicketStatus());

        //Cleanup
        userDao.delete(newUser);
    }

    @Test
    void getBetslips() {
        //Given
        User user = new User();

        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));

        List<Betslip> betslipList =new ArrayList<>();
        betslipList.add(betslip);

        user.setBetslips(betslipList);


        //When
        User newUser = userDao.save(user);

        //Then
        assertEquals(new BigDecimal(200), newUser.getBetslips().get(0).getToWin());

        //Cleanup
        userDao.delete(newUser);
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