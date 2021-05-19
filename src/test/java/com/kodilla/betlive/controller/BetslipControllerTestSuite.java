package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.BetMapper;
import com.kodilla.betlive.mapper.BetslipMapper;
import com.kodilla.betlive.mapper.TicketMapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class BetslipControllerTestSuite {


    @Autowired
    BetslipMapper betslipMapper;

    @Autowired
    BetMapper betMapper;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    BetslipController betslipController;

    @Autowired
    private BetslipDao betslipDao;


    @Test
    void getAllBets() {
        //Given
        BetslipDto betslipDto = new BetslipDto();
        BetDto betDto = new BetDto();
        betDto.setAwayTeam("away");

        List<BetDto> betDtos = new ArrayList<>();
        betDtos.add(betDto);

        betslipDto.setBets(betMapper.maptoBetList(betDtos));

        BetslipDto createdBetslip = betslipController.createBetslip(betslipDto);

        //When
        List<BetDto> result = betslipController.getAllBets(createdBetslip.getBetslipId());

        //Then
        assertEquals(createdBetslip.getBets().get(0).getAwayTeam(),result.get(0).getAwayTeam());
    }

    @Test
    void createBetslip() {
        //Given
        BetslipDto betslipDto = new BetslipDto();
        betslipDto.setToWin(new BigDecimal(25.0));

        //When
        BetslipDto result = betslipController.createBetslip(betslipDto);

        //Then
        assertEquals(betslipDto.getToWin(),result.getToWin());

    }

    @Test
    void addBet() {
        //Given
        BetslipDto betslipDto = new BetslipDto();
        betslipDto.setToWin(new BigDecimal(25.0));

        //When
        BetslipDto result = betslipController.createBetslip(betslipDto);

        //Then
        assertEquals(betslipDto.getToWin(),result.getToWin());
    }

    @Test
    void deleteBet() {
    }

    @Test
    void createTicket() {
    }
}
