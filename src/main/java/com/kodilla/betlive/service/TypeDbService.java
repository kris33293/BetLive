package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.BetDao;
import com.kodilla.betlive.domain.Type;
import com.kodilla.betlive.domain.TypeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeDbService {

    @Autowired
    TypeDao typeDao;

    public void deleteTypeByTypeId(int typeId) {
        typeDao.deleteById(typeId);
    }


    public Type save(Type type) {
        return typeDao.save(type);
    }

    public Type findById(int typeId) {
        return typeDao.findById(typeId);
    }
}
