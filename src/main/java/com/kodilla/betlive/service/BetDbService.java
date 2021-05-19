package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.BetDao;
import com.kodilla.betlive.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BetDbService {

     BetDao betDao;

    public Bet save(Bet bet) {
        return betDao.save(bet);
    }

    public Bet findById(int betId) {
        return betDao.findById(betId);
    }

}
