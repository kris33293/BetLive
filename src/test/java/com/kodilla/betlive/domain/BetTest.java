package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class BetTest {

    @Autowired
    BetDao betDao;


    @Test
    void setBetId() {
        //Given
        Bet bet = new Bet();

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertNotEquals(0, newBet.getBetId());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setOddHome() {
        //Given
        Bet bet = new Bet();
        bet.setOddHome(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddHome());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setOddAway() {
        //Given
        Bet bet = new Bet();
        bet.setOddAway(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddAway());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setOddDraw() {
        //Given
        Bet bet = new Bet();
        bet.setOddDraw(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddDraw());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setHomeTeam() {
        //Given
        Bet bet = new Bet();
        bet.setHomeTeam("team");

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals("team", newBet.getHomeTeam());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setAwayTeam() {
        //Given
        Bet bet = new Bet();
        bet.setAwayTeam("team");

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals("team", newBet.getAwayTeam());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void setEventDate() {
        //Given
        Bet bet = new Bet();
        bet.setEventDate(new Date(2020));

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(new Date(2020), newBet.getEventDate());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getBetId() {
        //Given
        Bet bet = new Bet();

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertNotEquals(0, newBet.getBetId());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getOddHome() {
        //Given
        Bet bet = new Bet();
        bet.setOddHome(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddHome());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getOddAway() {
        //Given
        Bet bet = new Bet();
        bet.setOddAway(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddAway());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getOddDraw() {
        //Given
        Bet bet = new Bet();
        bet.setOddDraw(20.0);

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(20.0, newBet.getOddDraw());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getHomeTeam() {
        //Given
        Bet bet = new Bet();
        bet.setHomeTeam("team");

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals("team", newBet.getHomeTeam());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getAwayTeam() {
        //Given
        Bet bet = new Bet();
        bet.setAwayTeam("team");

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals("team", newBet.getAwayTeam());

        //Clean up
        betDao.delete(newBet);
    }

    @Test
    void getEventDate() {
        //Given
        Bet bet = new Bet();
        bet.setEventDate(new Date(2020));

        //When
        Bet newBet = betDao.save(bet);

        //Then
        assertEquals(new Date(2020), newBet.getEventDate());

        //Clean up
        betDao.delete(newBet);
    }
}