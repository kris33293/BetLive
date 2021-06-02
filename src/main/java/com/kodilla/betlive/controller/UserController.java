package com.kodilla.betlive.controller;

import com.kodilla.betlive.domain.Betslip;
import com.kodilla.betlive.domain.Ticket;
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


    private final UserDbService userDbService;

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public User createUser(@RequestBody User user) {
        return userDbService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "checkBalance")
    public BigDecimal checkBalance(@RequestParam int userId) {
        return userDbService.checkBalance(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllUsers")
    public List<User> getAllUsers() {
        return userDbService.findALlUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "makeDeposit")
    public void makeDeposit(@RequestParam int userId, @RequestParam BigDecimal ammount) {
        userDbService.makeDeposit(userId, ammount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "withdrawMoney")
    public void withdrawMoney(@RequestParam int userId, @RequestParam BigDecimal ammount) {
        userDbService.withdrawMoney(userId, ammount);
    }


}
