package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.domain.UserDao;
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
class UserDbServiceTest {

    @Autowired
    UserDbService userDbService;

    @Autowired
    UserDao userDao;

    @Test
    void saveUser() {
        //Given
        User user = new User();

        //When
        userDbService.saveUser(user);

        //Then
        assertNotEquals(0, user.getUserId());

        //Clean up
        userDbService.deleteUserByUserId(user.getUserId());
    }

    @Test
    void deleteUserByUserId() {
        //Given
        User user = new User();
        userDbService.saveUser(user);

        //When
        userDbService.deleteUserByUserId(user.getUserId());

        //Then
        assertFalse(userDao.existsById(user.getUserId()));


    }

    @Test
    void checkBalance() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(200));
        userDbService.saveUser(user);

        //When
        BigDecimal result = userDbService.checkBalance(user.getUserId());

        //Then
        assertEquals(result, user.getBalance());

        //Clean up
        userDbService.deleteUserByUserId(user.getUserId());
    }

    @Test
    void makeDeposit() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(200));
        userDbService.saveUser(user);

        //When
        userDbService.makeDeposit(user.getUserId(), new BigDecimal(50));

        //Then
        assertEquals(new BigDecimal(250), user.getBalance());

        //Clean up
        userDbService.deleteUserByUserId(user.getUserId());
    }

    @Test
    void withdrawMoney() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(200));
        userDbService.saveUser(user);

        //When
        userDbService.withdrawMoney(user.getUserId(), new BigDecimal(50));

        //Then
        assertEquals(new BigDecimal(150), user.getBalance());

        //Clean up
        userDbService.deleteUserByUserId(user.getUserId());
    }

    @Test
    void checkUserTickets() {
        //Given
        User user = new User();
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setTicketStatus("WIN");
        Set<Ticket> tickets = new AbstractSet<Ticket>() {
            @Override
            public Iterator<Ticket> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
        tickets.add(ticket);
        user.setTickets(tickets);
        userDbService.saveUser(user);

        //When
        Ticket ticketResult = userDbService.checkUserTickets(user.getUserId()).iterator().next();

        //Then
        assertEquals(ticket.getTicketStatus(), ticketResult.getTicketStatus());

        //Clean up
        userDbService.deleteUserByUserId(user.getUserId());
    }
}