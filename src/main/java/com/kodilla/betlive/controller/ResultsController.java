package com.kodilla.betlive.controller;

import com.kodilla.betlive.client.ResultsApitoResultClient;

import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.footballdataapi.Data;
import com.kodilla.betlive.footballdataapi.client.FootballClient;
import com.kodilla.betlive.service.ResultDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/results")
@RequiredArgsConstructor
public class ResultsController {

    private final FootballClient footballClient;
    private final ResultDbService resultDbService;

    @GetMapping("getPremierleagueResults")
    public List<Data> getPremierleagueResults() {
        return footballClient.getPremierleagueScores();
    }

    @PostMapping("savePremierleagueResults")
    public void savePremierleagueResults() {
        List<Data> datas = getPremierleagueResults();
        ResultsApitoResultClient resultsApitoResultClient = new ResultsApitoResultClient(datas);
        List<Result> resultList = resultsApitoResultClient.resultToSave();
        for (Result result : resultList) {
            resultDbService.save(result);
        }
        System.out.println("Premierleague scores saved");
    }
}
