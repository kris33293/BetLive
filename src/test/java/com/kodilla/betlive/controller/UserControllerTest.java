package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.domain.UserDao;
import com.kodilla.betlive.service.UserDbService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserDao userDao;

    @Test
    void checkBalance() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(20));
        userDao.save(user);

        //When
        BigDecimal result = userController.checkBalance(user.getUserId());

        //Then
        assertEquals(user.getBalance(), result);

        //Clean Up
        userDao.delete(user);

    }

    @Test
    void makeDeposit() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(20));
        userDao.save(user);

        //When
        userController.makeDeposit(user.getUserId(), new BigDecimal(50));
        BigDecimal result = userController.checkBalance(user.getUserId());

        //Then
        assertEquals(new BigDecimal(70), result);

        //Clean Up
        userDao.delete(user);

    }

    @Test
    void withdrawMoney() {
        //Given
        User user = new User();
        user.setBalance(new BigDecimal(70));
        userDao.save(user);

        //When
        userController.withdrawMoney(user.getUserId(), new BigDecimal(50));
        BigDecimal result = userController.checkBalance(user.getUserId());

        //Then
        assertEquals(new BigDecimal(20), result);

        //Clean Up
        userDao.delete(user);

    }
}