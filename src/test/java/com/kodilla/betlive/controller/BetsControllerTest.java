package com.kodilla.betlive.controller;


import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.BetDao;
import com.kodilla.betlive.domain.BetslipDao;
import com.kodilla.betlive.domain.theoddsapi.Data;
import com.kodilla.betlive.service.BetDbService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class BetsControllerTest {

    @Autowired
    BetsController betsController;

    @Autowired
    BetDbService betDbService;


    @Test
    void getPremierleagueMatches() {
        //When
        List<Data> results = betsController.getPremierleagueMatches();

        //Then
        assertFalse(results.isEmpty());
    }

//    @Test
//    void savePremierleagueMatches() {
//        //When
//        betsController.savePremierleagueMatches();
//        Bet result = betDbService.findById(1);
//
//        //Then
//        assertFalse(result.getHomeTeam().isEmpty());
//    }
}