package com.kodilla.betlive.client;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.theoddsapi.BetApi;
import com.kodilla.betlive.domain.theoddsapi.Data;

import java.util.ArrayList;
import java.util.List;

public class BetApiToBetClient {


    List<Data> apiBets;

    public BetApiToBetClient(List<Data> apiBets) {
        this.apiBets = apiBets;
    }

    public List<BetApi> getBetApiList() {
        List<BetApi> resultList;
        resultList = apiBets.get(0).getBets();
        return resultList;
    }

    public List<Bet> betsToSave() {
        List<BetApi> results = getBetApiList();
        List<Bet> resultList = new ArrayList<>();

        for (BetApi betApi : results) {
            Bet bet = new Bet();
            bet.setBetId(betApi.getBetid());
            bet.setHomeTeam(betApi.getTeams().get(0));
            bet.setAwayTeam(betApi.getTeams().get(1));
            bet.setOddHome(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(0));
            bet.setOddAway(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(1));
            bet.setOddDraw(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(2));
            bet.setEventDate(betApi.getEventDate());
            resultList.add(bet);
        }
        return resultList;
    }


}
