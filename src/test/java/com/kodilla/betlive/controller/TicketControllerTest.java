package com.kodilla.betlive.controller;

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
class TicketControllerTest {

    @Autowired
    TicketController ticketController;


    @Test
    void getAllTickets() {
    }

    @Test
    void getTicket() {
    }

    @Test
    void getUserTicket() {
    }

    @Test
    void checkTicketStatus() {
    }
}