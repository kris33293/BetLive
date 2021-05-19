package com.kodilla.betlive.theoddsapi.client;

import com.kodilla.betlive.domain.Data;
import com.kodilla.betlive.theoddsapi.config.ApiConfig;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.*;

@Service
@Component
@RequiredArgsConstructor
public class OddsClient {


    private final RestTemplate restTemplate = restTemplate();
    private final ApiConfig apiConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(OddsClient.class);

    public List<Data> getPremierleagueMatches() {
        URI url = UriComponentsBuilder.fromHttpUrl(apiConfig.getApiEndpoint())
                .queryParam("sport", "soccer_epl")
                .queryParam("region", "eu")
                .queryParam("mkt", "h2h")
                .queryParam("dateFormat", "iso")
                .queryParam("oddsFormat", "decimal")
                .build()
                .encode()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "db5c51d57fmsha3e1f8bd384311cp188de2jsn3c2d86dfce2d");

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
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
