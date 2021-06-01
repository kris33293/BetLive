package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDao;
import com.kodilla.betlive.domain.User;
import com.kodilla.betlive.domain.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDbService {

    @Autowired
    private final UserDao userDao;
    @Autowired
    private final TicketDao ticketDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUserByUserId(int userId) {
        userDao.deleteUserByUserId(userId);
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

    public Set<Ticket> checkUserTickets(int userId) {
        return ticketDao.findByUserUserId(userId);
    }

    public List<User> findALlUsers(){ return userDao.findAll();}

}
