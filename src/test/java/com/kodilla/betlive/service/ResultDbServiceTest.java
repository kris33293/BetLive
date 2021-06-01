package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Result;
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
class ResultDbServiceTest {

    @Autowired
    ResultDbService resultDbService;

    @Test
    void save() {
        //Given
        Result result = new Result();

        //When
        resultDbService.save(result);

        //Then
        assertNotEquals(0, result.getResultId());

        //Clean Up
        resultDbService.resultDao.delete(result);
    }

    @Test
    void findById() {
        //Given
        Result result = new Result();
        result.setResult("HOME_WIN");
        resultDbService.save(result);

        //When
        Result reslutSearch = resultDbService.findById(result.getResultId());

        //Then
        assertEquals(result.getResult(), reslutSearch.getResult());

        //Clean Up
        resultDbService.resultDao.delete(result);
    }

    @Test
    void findAll() {
        //Given
        Result result = new Result();
        result.setResult("HOME_WIN");
        resultDbService.save(result);

        //When
        Result reslutSearch = resultDbService.findAll().get(0);

        //Then
        assertEquals(result.getResult(), reslutSearch.getResult());

        //Clean Up
        resultDbService.resultDao.delete(result);
    }
}