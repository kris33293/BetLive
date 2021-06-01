package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Bet;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class BetDbServiceTest {

    @Autowired
    BetDbService betDbService;

    @Test
    void save() {
        //Given
        Bet bet = new Bet();

        //When
        betDbService.save(bet);

        //Then
        assertNotEquals(0, bet.getBetId());

        //Clean up
        betDbService.betDao.save(bet);
    }

    @Test
    void findById() {
        //Given
        Bet bet = new Bet();
        bet.setOddDraw(2.0);
        betDbService.save(bet);

        //When
        Bet foundBet = betDbService.findById(bet.getBetId());

        //Then
        assertEquals(bet.getOddDraw(), foundBet.getOddDraw());

        //Clean up
        betDbService.betDao.save(bet);
    }
}