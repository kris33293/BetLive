package com.kodilla.betlive.domain.theoddsapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.betlive.domain.theoddsapi.BetApi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Data {

    @JsonProperty("data")
    private List<BetApi> bets;

}
