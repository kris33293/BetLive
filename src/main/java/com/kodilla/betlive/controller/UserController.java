package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDto;
import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.service.TicketDbService;
import com.kodilla.betlive.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final TicketMapper ticketMapper;
    private final UserDbService userDbService;
    private final TicketDbService ticketDbService;


    @RequestMapping(method = RequestMethod.GET, value = "checkBalance")
    public BigDecimal checkBalance(int userId) {
        return userDbService.checkBalance(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "makeDeposit")
    public void makeDeposit(@RequestParam int userId, @RequestParam BigDecimal ammount) {
        userDbService.makeDeposit(userId,ammount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "withdrawMoney")
    public void withdrawMoney(@RequestParam int userId, @RequestParam BigDecimal ammount) {
        userDbService.withdrawMoney(userId,ammount);
    }


}
