package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.BetDao;
import com.kodilla.betlive.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetDbService {

    @Autowired
    BetDao betDao;

    public Bet save(Bet bet) {
        return betDao.save(bet);
    }

    public Bet findById(int betId) {
        return betDao.findById(betId);
    }

    public List<Bet> findAll() { return betDao.findAll();}

    public void deleteAll() { betDao.deleteAll();}

}
