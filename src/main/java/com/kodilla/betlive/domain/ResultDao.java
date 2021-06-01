package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ResultDao extends CrudRepository<Result, Integer> {

    @Override
    Result save(Result result);

    Result findById(int resultId);

    List<Result> findAll();

}
