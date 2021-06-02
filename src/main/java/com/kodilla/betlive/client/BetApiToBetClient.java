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
            Bet bet = new Bet.BetBuilder()
                    .betId(betApi.getBetid())
                    .awayTeam(betApi.getTeams().get(1))
                    .homeTeam(betApi.getTeams().get(0))
                    .eventDate(betApi.getEventDate())
                    .oddAway(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(1))
                    .oddDraw(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(2))
                    .oddHome(betApi.getOddsBase().get(0).getOddsSet().getOdds().get(0))
                    .build();

            resultList.add(bet);
        }
        return resultList;
    }


}
