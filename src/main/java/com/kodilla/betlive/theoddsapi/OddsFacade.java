package com.kodilla.betlive.theoddsapi;


import com.kodilla.betlive.domain.theoddsapi.Data;
import com.kodilla.betlive.footballdataapi.FootballFacade;
import com.kodilla.betlive.theoddsapi.client.OddsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(OddsFacade.class);
    @Autowired
    OddsClient oddsClient;

    public List<Data> getMatches(){
        LOGGER.info("Transfering Available Matches");
        return oddsClient.getPremierleagueMatches();
    }
}
