package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class TypeTest {

    @Autowired
    TypeDao typeDao;

    @Test
    void setTypeId() {
        //Given
        Type type = new Type();

        //When
        Type newType = typeDao.save(type);

        //Then
        assertNotEquals(0, newType.getTypeId());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void setHomeTeam() {
        //Given
        Type type = new Type();
        type.setHomeTeam("hometeam");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("hometeam", newType.getHomeTeam());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void setAwayTeam() {
        //Given
        Type type = new Type();
        type.setAwayTeam("awayteam");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("awayteam", newType.getAwayTeam());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void setEventDate() {
        //Given
        Type type = new Type();
        type.setEventDate(new Date(22 / 02 / 20));

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new Date(22 / 02 / 20), newType.getEventDate());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void setOdd() {
        //Given
        Type type = new Type();
        type.setOdd(20.0);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(20.0, newType.getOdd());

        //Clean up
        typeDao.delete(newType);

    }

    @Test
    void setYourType() {
        //Given
        Type type = new Type();
        type.setYourType("HOME_TEAM");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("HOME_TEAM", newType.getYourType());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void setBetslips() {
        //Given
        Type type = new Type();
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);
        type.setBetslips(betslips);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new BigDecimal(200), newType.getBetslips().get(0).getToWin());

        //Clean up
        typeDao.delete(newType);

    }

    @Test
    void setTickets() {
        //Given
        Type type = new Type();
        Ticket ticket = new Ticket();
        ticket.setToWin(new BigDecimal(200));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        type.setTickets(tickets);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new BigDecimal(200), newType.getTickets().get(0).getToWin());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getTypeId() {
        //Given
        Type type = new Type();

        //When
        Type newType = typeDao.save(type);

        //Then
        assertNotEquals(0, newType.getTypeId());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getHomeTeam() {
        //Given
        Type type = new Type();
        type.setHomeTeam("hometeam");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("hometeam", newType.getHomeTeam());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getAwayTeam() {
        //Given
        Type type = new Type();
        type.setAwayTeam("awayteam");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("awayteam", newType.getAwayTeam());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getEventDate() {
        //Given
        Type type = new Type();
        type.setEventDate(new Date(22 / 02 / 20));

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new Date(22 / 02 / 20), newType.getEventDate());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getOdd() {
        //Given
        Type type = new Type();
        type.setOdd(20.0);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(20.0, newType.getOdd());

        //Clean up
        typeDao.delete(newType);

    }

    @Test
    void getYourType() {
        //Given
        Type type = new Type();
        type.setYourType("HOME_TEAM");

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals("HOME_TEAM", newType.getYourType());

        //Clean up
        typeDao.delete(newType);
    }

    @Test
    void getBetslips() {
        //Given
        Type type = new Type();
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);
        type.setBetslips(betslips);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new BigDecimal(200), newType.getBetslips().get(0).getToWin());

        //Clean up
        typeDao.delete(newType);

    }

    @Test
    void getTickets() {
        //Given
        Type type = new Type();
        Ticket ticket = new Ticket();
        ticket.setToWin(new BigDecimal(200));
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket);
        type.setTickets(tickets);

        //When
        Type newType = typeDao.save(type);

        //Then
        assertEquals(new BigDecimal(200), newType.getTickets().get(0).getToWin());

        //Clean up
        typeDao.delete(newType);
    }
}