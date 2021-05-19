package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BetDao extends CrudRepository<Bet, Integer> {

    @Override
    Bet save (Bet bet);

    Bet findById(int betId);
}
