package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Type;
import com.kodilla.betlive.domain.TypeDao;
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
class TypeDbServiceTest {

    @Autowired
    TypeDbService typeDbService;

    @Autowired
    TypeDao typeDao;

    @Test
    void deleteTypeByTypeId() {
        //Given
        Type type = new Type();
        typeDbService.save(type);

        //When
        typeDbService.deleteTypeByTypeId(type.getTypeId());

        //Then
        assertFalse(typeDao.existsById(type.getTypeId()));
    }

    @Test
    void save() {
        //Given
        Type type = new Type();

        //When
        typeDbService.save(type);

        //Then
        assertNotEquals(0, type.getTypeId());

        //Clean up
        typeDbService.deleteTypeByTypeId(type.getTypeId());
    }

    @Test
    void findById() {
        //Given
        Type type = new Type();
        type.setAwayTeam("away");
        typeDbService.save(type);

        //When
        Type expected = typeDbService.findById(type.getTypeId());
        //Then
        assertEquals("away", type.getAwayTeam());

        //Clean up
        typeDbService.deleteTypeByTypeId(type.getTypeId());

    }
}