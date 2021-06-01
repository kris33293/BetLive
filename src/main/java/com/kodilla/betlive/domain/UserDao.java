package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Override
    User save(User user);

    User findByUserId(int userId);

    void deleteUserByUserId(int userId);

    List<User> findAll();

}
