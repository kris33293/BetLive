package com.kodilla.betlive.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter

public class BookiesData {

    @JsonProperty("odds")
    H2h oddsSet;
}
