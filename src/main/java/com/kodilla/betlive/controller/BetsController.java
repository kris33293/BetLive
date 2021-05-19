package com.kodilla.betlive.controller;

import com.kodilla.betlive.client.BetApiToBetClient;
import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.Data;
import com.kodilla.betlive.service.BetDbService;
import com.kodilla.betlive.theoddsapi.client.OddsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/oddsapi")
@RequiredArgsConstructor
public class BetsController {


    private final OddsClient oddsClient;
    private final BetDbService betDbService;


    @GetMapping("getPremierleagueMatches")
    public List<Data> getPremierleagueMatches() {
        return oddsClient.getPremierleagueMatches();
    }

    @PostMapping("savePremierleagueMatches")
    public void savePremierleagueMatches() {
        List<Data> datas = oddsClient.getPremierleagueMatches();
        BetApiToBetClient betApiToBetClient = new BetApiToBetClient(datas);
        List<Bet> resultList = betApiToBetClient.betsToSave();
        for (Bet bet : resultList) {
            betDbService.save(bet);
        }
        System.out.println("Premierleague matches saved");
    }
}
