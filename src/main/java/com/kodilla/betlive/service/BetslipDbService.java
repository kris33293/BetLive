package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BetslipDbService {

    @Autowired
    private final BetslipDao betslipDao;
    @Autowired
    private final TicketDao ticketDao;


    public Betslip createBetslip(Betslip betslip) {
        return betslipDao.save(betslip);
    }

    public Betslip findBetslip(int betslipId) {
        return betslipDao.findBetslipByBetslipId(betslipId);
    }

    public Set<Type> findAllTypes(int betslipId) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        return betslip.getTypes();
    }

    public void addType(int betslipId, Type type) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        Set<Type> types = betslip.getTypes();
        types.add(type);
        betslip.setTypes(types);
        betslipDao.save(betslip);
    }

    public void deleteType(int betslipId, Type type) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        Set<Type> types = betslip.getTypes();
        types.remove(type);
        betslip.setTypes(types);
        betslipDao.save(betslip);
    }

    public void deleteBetslip(int betslipId) {
        betslipDao.deleteById(betslipId);
    }

    public Ticket createTicket(Betslip betslip) {
        Ticket ticket = new Ticket();
        ticket.setTypes(betslip.getTypes());
        ticket.setUser(betslip.getUser());
        ticket.setTotalStake(betslip.getTotalStake());
        ticket.setToWin(betslip.getToWin());
        ticket.setTotalOdds(betslip.getTotalOdds());
        ticket.setBetslip(betslip);
        ticket.setTicketStatus("pending");
        return ticketDao.save(ticket);
    }

}
