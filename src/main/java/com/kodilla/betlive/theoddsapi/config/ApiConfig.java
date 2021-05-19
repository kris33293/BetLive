package com.kodilla.betlive.theoddsapi.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Component
public class ApiConfig {

    @Value("${odds.api.endpoint}")
    private String apiEndpoint;
    @Value("${odds.api.rapidapi}")
    private String rapidapi;
}
