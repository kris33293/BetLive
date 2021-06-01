package com.kodilla.betlive.domain.footballdataapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HomeTeam {

    @JsonProperty("name")
    String name;
}
