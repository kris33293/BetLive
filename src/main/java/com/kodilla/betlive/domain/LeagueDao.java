package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;

public interface LeagueDao extends CrudRepository<League, Integer> {

    @Override
    League save(League league);
}
