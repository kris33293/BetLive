package com.kodilla.betlive.domain;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BetslipDao extends CrudRepository<Betslip, Integer> {

    @Override
    Betslip save (Betslip betslip);

    Betslip findBetslipByBetslipId(int bestslipId);



}
