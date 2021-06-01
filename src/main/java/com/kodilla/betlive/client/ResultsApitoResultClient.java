package com.kodilla.betlive.client;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.footballdataapi.Data;
import com.kodilla.betlive.domain.footballdataapi.ResultsApi;
import com.kodilla.betlive.domain.theoddsapi.BetApi;

import java.util.ArrayList;
import java.util.List;

public class ResultsApitoResultClient {

    private final List<Data> resultsApiData;

    public ResultsApitoResultClient(List<Data> resultsApiData) {
        this.resultsApiData = resultsApiData;
    }

    public List<ResultsApi> getResultsApiList() {
        List<ResultsApi> resultList = resultsApiData.get(0).getBets();

        return resultList;
    }

    public List<Result> resultToSave() {
        List<ResultsApi> results = getResultsApiList();
        List<Result> resultList = new ArrayList<>();

        for (ResultsApi resultsApi : results) {
            Result result = new Result();
            result.setResultId(resultsApi.getResultId());
            result.setHomeTeam(resultsApi.getHometeam().getName());
            result.setAwayTeam(resultsApi.getAwayteam().getName());
            result.setResult(resultsApi.getScore().getResult());
            resultList.add(result);
        }
        return resultList;
    }
}
