package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.Type;
import com.kodilla.betlive.domain.TypeDao;
import com.kodilla.betlive.service.TypeDbService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class TypeControllerTest {

    @Autowired
    TypeController typeController;

    @Autowired
    TypeDao typeDao;

    @Test
    void createType() {
        //Given
        Type type = new Type();
        type.setYourType("HOME_WIN");

        //When
        Type newType = typeController.createType(type);

        //Then
        assertEquals(type.getYourType(), newType.getYourType());

        //Clean up
        typeDao.delete(type);
    }
}