package com.kodilla.betlive.domain;

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
class ResultTest {

    @Autowired
    ResultDao resultDao;

    @Test
    void setResultId() {
        //Given
        Result result = new Result();

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertNotEquals(0, newResult.getResultId());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void setResult() {
        //Given
        Result result = new Result();
        result.setResult("HOME_WIN");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("HOME_WIN", newResult.getResult());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void setHomeTeam() {
        //Given
        Result result = new Result();
        result.setHomeTeam("HOMETEAM");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("HOMETEAM", newResult.getHomeTeam());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void setAwayTeam() {
        //Given
        Result result = new Result();
        result.setAwayTeam("AWAYTEAM");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("AWAYTEAM", newResult.getAwayTeam());

        //Clean up
        resultDao.delete(result);
    }


    @Test
    void getResultId() {
        //Given
        Result result = new Result();

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertNotEquals(0, newResult.getResultId());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void getResult() {
        //Given
        Result result = new Result();
        result.setResult("HOME_WIN");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("HOME_WIN", newResult.getResult());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void getHomeTeam() {
        //Given
        Result result = new Result();
        result.setHomeTeam("HOMETEAM");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("HOMETEAM", newResult.getHomeTeam());

        //Clean up
        resultDao.delete(result);
    }

    @Test
    void getAwayTeam() {
        //Given
        Result result = new Result();
        result.setAwayTeam("AWAYTEAM");

        //When
        Result newResult = resultDao.save(result);

        //Then
        assertEquals("AWAYTEAM", newResult.getAwayTeam());

        //Clean up
        resultDao.delete(result);
    }
}