package com.kodilla.betlive.footballdataapi;


import com.kodilla.betlive.domain.footballdataapi.Data;
import com.kodilla.betlive.footballdataapi.client.FootballClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FootballFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(FootballFacade.class);

    @Autowired
    FootballClient footballClient;

    public List<Data> getResults(){
        LOGGER.info("Transfering Available Results");
        return footballClient.getPremierleagueScores();
    }
}
