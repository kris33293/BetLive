package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDao;
import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.domain.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserDao userDao;
    private final TicketDao ticketDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUserByUserName(String userName) {
        userDao.deleteUserByUserName(userName);
    }


    public BigDecimal checkBalance(int userId) {
        User user = userDao.findByUserId(userId);
        return user.getBalance();
    }

    public void makeDeposit(int userId, BigDecimal ammount) {
        User user = userDao.findByUserId(userId);
        user.setBalance(user.getBalance().add(ammount));
    }

    public void withdrawMoney(int userId, BigDecimal ammount) {
        User user = userDao.findByUserId(userId);
        user.setBalance(user.getBalance().subtract(ammount));
    }

    public List<Ticket> checkUserTickets(int userId) {
        return ticketDao.findByUserUserId(userId);
    }

}
