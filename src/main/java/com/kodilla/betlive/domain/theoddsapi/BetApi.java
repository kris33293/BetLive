package com.kodilla.betlive.domain.theoddsapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BetApi {

    @Id
    @GeneratedValue
    @NotNull
    private int betid;

    @JsonProperty("sites")
    List<BookiesData> oddsBase;
    @JsonProperty("teams")
    private List<String> teams;
    @JsonProperty("sport_key")
    private String league;
    @JsonProperty("commence_time")
    private Date eventDate;

}
