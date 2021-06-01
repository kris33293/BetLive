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
class BetslipTest {

    @Autowired
    BetslipDao betslipDao;

    @Test
    void setBetslipId() {
        //Given
        Betslip betslip = new Betslip();

        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertNotEquals(0, newBetslip.getBetslipId());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setTypes() {
        //Given
        Betslip betslip = new Betslip();
        Type type = new Type();
        type.setHomeTeam("home");
        List<Type> types = new ArrayList<>();
        types.add(type);
        betslip.setTypes(types);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals("home", newBetslip.getTypes().get(0).getHomeTeam());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setUser() {
        Betslip betslip = new Betslip();
        User user = new User();
        user.setUserName("name");
        betslip.setUser(user);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals("name", newBetslip.getUser().getUserName());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setTotalOdds() {
        Betslip betslip = new Betslip();
        betslip.setTotalOdds(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setTotalStake() {
        Betslip betslip = new Betslip();
        betslip.setTotalStake(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTotalStake());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setToWin() {
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getToWin());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void setTicket() {
        Betslip betslip = new Betslip();
        Ticket ticket = new Ticket();
        ticket.setTotalOdds(new BigDecimal(200));
        betslip.setTicket(ticket);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTicket().getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getBetslipId() {
        //Given
        Betslip betslip = new Betslip();

        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertNotEquals(0, newBetslip.getBetslipId());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getTypes() {
        //Given
        Betslip betslip = new Betslip();
        Type type = new Type();
        type.setHomeTeam("home");
        List<Type> types = new ArrayList<>();
        types.add(type);
        betslip.setTypes(types);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals("home", newBetslip.getTypes().get(0).getHomeTeam());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getUser() {
        Betslip betslip = new Betslip();
        User user = new User();
        user.setUserName("name");
        betslip.setUser(user);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals("name", newBetslip.getUser().getUserName());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getTotalOdds() {
        Betslip betslip = new Betslip();
        betslip.setTotalOdds(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getTotalStake() {
        Betslip betslip = new Betslip();
        betslip.setTotalStake(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTotalStake());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getToWin() {
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(200));


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getToWin());

        //Cleanup
        betslipDao.delete(betslip);
    }

    @Test
    void getTicket() {
        Betslip betslip = new Betslip();
        Ticket ticket = new Ticket();
        ticket.setTotalOdds(new BigDecimal(200));
        betslip.setTicket(ticket);


        //When
        Betslip newBetslip = betslipDao.save(betslip);

        //Then
        assertEquals(new BigDecimal(200), newBetslip.getTicket().getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
    }
}