package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.*;
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
class BetslipDbServiceTest {

    @Autowired
    BetslipDbService betslipDbService;

    @Autowired
    TicketDao ticketDao;

    @Autowired
    BetslipDao betslipDao;

    @Test
    void createBetslip() {
        //Given
        Betslip betslip = new Betslip();

        //When
        betslipDbService.createBetslip(betslip);

        //Then
        assertNotEquals(0, betslip.getBetslipId());

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void findBetslip() {
        //Given
        Betslip betslip = new Betslip();
        betslip.setToWin(new BigDecimal(20));
        betslipDbService.createBetslip(betslip);


        //When
        Betslip betslipSearched = betslipDbService.findBetslip(betslip.getBetslipId());

        //Then
        assertEquals(betslip.getToWin(), betslipSearched.getToWin());

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void findAllTypes() {
        //Given
        Betslip betslip = new Betslip();
        Type type = new Type();
        type.setYourType("type");
        List<Type> types = new ArrayList<>();
        types.add(type);
        betslip.setTypes(types);
        betslipDbService.createBetslip(betslip);

        //When
        List<Type> searchedTypes = betslipDbService.findAllTypes(betslip.getBetslipId());

        //Then
        assertEquals("type", searchedTypes.get(0).getYourType());

        //Clean up
        betslipDao.delete(betslip);

    }

    @Test
    void addType() {
        //Given
        Betslip betslip = new Betslip();
        List<Type> types = new ArrayList<>();
        betslip.setTypes(types);
        Type type = new Type();
        type.setYourType("type");
        betslipDbService.createBetslip(betslip);

        //When
        betslipDbService.addType(betslip.getBetslipId(), type);
        Betslip betslipSearched = betslipDbService.findBetslip(betslip.getBetslipId());

        //Then
        assertEquals(type.getYourType(), betslipSearched.getTypes().get(0).getYourType());

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void deleteType() {
        //Given
        Betslip betslip = new Betslip();
        Type type = new Type();
        type.setYourType("type");
        List<Type> types = new ArrayList<>();
        types.add(type);
        betslip.setTypes(types);
        betslipDbService.createBetslip(betslip);

        //When
        betslipDbService.deleteType(betslip.getBetslipId(), type);
        Betslip betslipSearched = betslipDbService.findBetslip(betslip.getBetslipId());

        //Then
        assertEquals(0, betslipSearched.getTypes().size());

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void createTicket() {
        //Given
        Betslip betslip = new Betslip();
        User user = new User();
        betslip.setUser(user);
        betslip.setTotalStake(new BigDecimal(10));
        betslip.setTotalOdds(new BigDecimal(10));
        List<Betslip> betslips = new ArrayList<>();
        betslips.add(betslip);
        user.setBetslips(betslips);
        betslipDbService.createBetslip(betslip);

        //When
        Ticket ticket = betslipDbService.createTicket(betslip);

        //Then
        assertEquals(betslip.getTotalOdds(), ticket.getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
        ticketDao.deleteAll();

    }
}