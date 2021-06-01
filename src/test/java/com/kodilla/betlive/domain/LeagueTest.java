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
class LeagueTest {

    @Autowired
    LeagueDao leagueDao;

    @Test
    void setLeagueId() {
        //Given
        League league = new League();

        //When
        League newLeague = leagueDao.save(league);

        //Then
        assertNotEquals(0, newLeague.getLeagueId());

        //Clean up
        leagueDao.delete(league);
    }

    @Test
    void setLeagueName() {
        //Given
        League league = new League();
        league.setLeagueName("leaguename");

        //When
        League newLeague = leagueDao.save(league);

        //Then
        assertEquals("leaguename", newLeague.getLeagueName());

        //Clean up
        leagueDao.delete(league);
    }

    @Test
    void getLeagueId() {
        //Given
        League league = new League();

        //When
        League newLeague = leagueDao.save(league);

        //Then
        assertNotEquals(0, newLeague.getLeagueId());

        //Clean up
        leagueDao.delete(league);
    }

    @Test
    void getLeagueName() {
        //Given
        League league = new League();
        league.setLeagueName("leaguename");

        //When
        League newLeague = leagueDao.save(league);

        //Then
        assertEquals("leaguename", newLeague.getLeagueName());

        //Clean up
        leagueDao.delete(league);
    }
}