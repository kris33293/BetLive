package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.ResultDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultDbService {

    @Autowired
    ResultDao resultDao;

    public Result save(Result result) {
        return resultDao.save(result);
    }

    public Result findById(int resultId) {
        return resultDao.findById(resultId);
    }

    public List<Result> findAll() {
        return resultDao.findAll();
    }

    ;
}
