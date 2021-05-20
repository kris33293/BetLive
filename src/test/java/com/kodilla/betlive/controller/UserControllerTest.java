package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.service.TicketDbService;
import com.kodilla.betlive.service.UserDbService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class UserControllerTest {


    @Autowired
    UserDao userDao;

    @Autowired
    UserDbService userDbService;

    @Autowired
    UserController userController;

    @Autowired
    TicketDao ticketDao;

    @Test
    void checkBalance() {
        //Given
        User user = new User();
        user.setUserName("username");
        user.setBalance(new BigDecimal(250.0));
        userDbService.saveUser(user);

        //When
        BigDecimal result = userController.checkBalance(1);

        //Then
        assertEquals(new BigDecimal(250.0), result);

        userDao.deleteAll();
    }

    @Test
    void makeDeposit() {
        //Given
        User user = new User();
        user.setUserName("username");
        user.setBalance(new BigDecimal(250.0));
        userDbService.saveUser(user);

        //When
        userController.makeDeposit(1, new BigDecimal(50.0));
        BigDecimal result = userController.checkBalance(1);

        //Then
        assertEquals(new BigDecimal(300.0), result);

    }

    @Test
    void withdrawMoney() {
        //Given
        User user = new User();
        user.setUserName("username");
        user.setBalance(new BigDecimal(250.0));
        userDbService.saveUser(user);

        //When
        userController.withdrawMoney(1, new BigDecimal(50.0));
        BigDecimal result = userController.checkBalance(1);

        //Then
        assertEquals(new BigDecimal(200.0), result);

        userDao.deleteAll();


    }

}