package com.kodilla.betlive.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TypeDao extends CrudRepository<Type, Integer> {

    @Override
    Type save(Type type);

    Type findById(int typeId);

    List<Type> findAll();
}
