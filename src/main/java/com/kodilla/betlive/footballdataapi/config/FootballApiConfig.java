package com.kodilla.betlive.footballdataapi.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class FootballApiConfig {


    private String apiEndpoint = "http://api.football-data.org/v2/competitions/PL/matches";
    private String apiToken = "74f5ce804d434cb4a0b312586c72b5c2";
}
