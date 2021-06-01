package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.BetslipMapper;
import com.kodilla.betlive.service.BetslipDbService;
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
class BetslipControllerTest {

    @Autowired
    BetslipController betslipController;

    @Autowired
    BetslipDao betslipDao;

    @Autowired
    TypeDao typeDao;

    @Autowired
    TicketDao ticketDao;

    @Autowired
    BetslipDbService betslipDbService;

    @Test
    void getAllTypes() {
        //Given
        Betslip betslip = new Betslip();
        Type type = new Type();
        type.setYourType("type");
        Set<Type> types = new AbstractSet<Type>() {
            @Override
            public Iterator<Type> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        types.add(type);
        betslip.setTypes(types);
        betslipDbService.createBetslip(betslip);

        //When
        Set<TypeDto> searchedTypes = betslipController.getAllTypes();

        //Then
        assertEquals("type", searchedTypes.equals(type.getYourType()));

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void createBetslip() {
        //When
        BetslipDto betslipDto = new BetslipDto();
        betslipDto.setToWin(new BigDecimal(20));

        //When
        BetslipDto created = betslipController.createBetslip(betslipDto);

        //Then
        assertEquals(betslipDto.getToWin(), created.getToWin());

        //Cleanup
        betslipDao.deleteAll();
    }

    @Test
    void addType() {
        //Given
        Betslip betslip = new Betslip();
        Set<Type> types = new AbstractSet<Type>() {
            @Override
            public Iterator<Type> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        betslip.setTypes(types);
        Type type = new Type();
        type.setYourType("type");
        betslipDbService.createBetslip(betslip);

        //When
        betslipController.addType(type.getTypeId(), betslip.getBetslipId());
        Betslip betslipSearched = betslipDbService.findBetslip(betslip.getBetslipId());

        //Then
        assertFalse(betslipSearched.getTypes().isEmpty());

        //Clean up
        betslipDao.delete(betslip);
    }

    @Test
    void deleteType() {
        //Given
        Betslip betslip = new Betslip();
        Set<Type> types = new AbstractSet<Type>() {
            @Override
            public Iterator<Type> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };

        betslip.setTypes(types);
        Type type = new Type();
        type.setYourType("type");
        betslipDbService.createBetslip(betslip);
        betslipController.addType(type.getTypeId(), betslip.getBetslipId());
        Betslip betslipSearched = betslipDbService.findBetslip(betslip.getBetslipId());

        //When
        betslipController.deleteType(type.getTypeId(), betslip.getBetslipId());
        //Then
        assertTrue(betslipSearched.getTypes().isEmpty());

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
        Ticket ticket = betslipController.createTicket(betslip.getBetslipId());

        //Then
        assertEquals(betslip.getTotalOdds(), ticket.getTotalOdds());

        //Cleanup
        betslipDao.delete(betslip);
        ticketDao.deleteAll();
    }
}