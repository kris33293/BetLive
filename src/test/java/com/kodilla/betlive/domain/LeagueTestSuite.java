package com.kodilla.betlive.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static com.helger.commons.mock.CommonsAssert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class LeagueTestSuite {

    @Autowired
    private LeagueDao leagueDao;

    @Test
    public void testCreateLeague() {
        //Given
        League league = new League();
        league.setLeagueName("PREMIERSHIP");
        league.setApiLeagueName("PREMIER");

        //When
        leagueDao.save(league);

        //Then
        int id = league.getLeagueId();
        assertNotEquals(0, id);

        //CleanUp
        leagueDao.deleteById(id);
    }

    @Test
    public void testDeleteLeague() {
        //Given
        League league = new League();
        league.setLeagueName("PREMIERSHIP");
        league.setApiLeagueName("PREMIER");

        //When
        leagueDao.save(league);
        leagueDao.deleteById(league.getLeagueId());
        //Then
        assertFalse(leagueDao.existsById(league.getLeagueId()));


    }

}
