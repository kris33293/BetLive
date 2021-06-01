package com.kodilla.betlive.domain.footballdataapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResultsApi {

    @Id
    @GeneratedValue
    @NotNull
    private int resultId;

    @JsonProperty("score")
    Score score;

    @JsonProperty("homeTeam")
    HomeTeam hometeam;

    @JsonProperty("awayTeam")
    AwayTeam awayteam;

}
