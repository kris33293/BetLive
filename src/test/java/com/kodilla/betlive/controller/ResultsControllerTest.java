package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.ResultDao;
import com.kodilla.betlive.domain.footballdataapi.Data;
import com.kodilla.betlive.service.ResultDbService;
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
class ResultsControllerTest {

    @Autowired
    ResultsController resultsController;

    @Autowired
    ResultDbService resultDbService;

    @Autowired
    ResultDao resultDao;

    @Test
    void getPremierleagueResults() {
        //When
        List<Data> results = resultsController.getPremierleagueResults();

        //Then
        assertFalse(results.isEmpty());
    }

    @Test
    void savePremierleagueResults() {
        //When
        resultsController.savePremierleagueResults();
        List<Result> results = resultDbService.findAll();

        //Then
        assertFalse(results.isEmpty());

        //Cleanup
        resultDao.deleteAll();

    }
}