package com.kodilla.betlive.domain.footballdataapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Data {

    @JsonProperty("matches")
    private List<ResultsApi> bets;
}
