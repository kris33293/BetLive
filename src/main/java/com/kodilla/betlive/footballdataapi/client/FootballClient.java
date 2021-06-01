package com.kodilla.betlive.footballdataapi.client;

import com.kodilla.betlive.domain.footballdataapi.Data;
import com.kodilla.betlive.footballdataapi.config.FootballApiConfig;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Component
@RequiredArgsConstructor
public class FootballClient {

    private final RestTemplate restTemplate = restTemplate2();
    @Autowired
    private final FootballApiConfig footballApiConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(FootballClient.class);
    private LocalDate today = LocalDate.now();

    public List<Data> getPremierleagueScores() {
        URI url = UriComponentsBuilder.fromHttpUrl(footballApiConfig.getApiEndpoint())
                .queryParam("dateFrom", "2021-05-19")
                .queryParam("dateTo", "2021-05-19")
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", footballApiConfig.getApiToken());

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<Data> boardsResponse = restTemplate.exchange(
                url, HttpMethod.GET, entity, Data.class);
        try {
            return Optional.ofNullable(boardsResponse.getBody())
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();

        }
    }

    @Bean
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }
}
