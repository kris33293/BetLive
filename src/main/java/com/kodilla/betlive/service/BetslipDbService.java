package com.kodilla.betlive.service;

import com.kodilla.betlive.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetslipDbService {

    private final BetslipDao betslipDao;
    private final TicketDao ticketDao;
    private final TicketStatusDao ticketStatusDao;

    public Betslip createBetslip(Betslip betslip) {
        return betslipDao.save(betslip);
    }

    public Betslip findBetslip(int betslipId) {
        return betslipDao.findBetslipByBetslipId(betslipId);
    }

    public List<Bet> findAllBets(int betslipId) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        return betslip.getBets();
    }

    public void addBet(int betslipId, Bet bet) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        List<Bet> bets = betslip.getBets();
        bets.add(bet);
        betslip.setBets(bets);
        betslipDao.save(betslip);
    }

    public void deleteBet(int betslipId, Bet bet) {
        Betslip betslip = betslipDao.findBetslipByBetslipId(betslipId);
        List<Bet> bets = betslip.getBets();
        bets.remove(bet);
        betslip.setBets(bets);
        betslipDao.save(betslip);
    }

    public Ticket createTicket(Betslip betslip) {
        TicketStatus ticketStatus = ticketStatusDao.findTicketStatusByTicketStatusId(0);
        Ticket ticket = new Ticket(betslip.getBetslipId(), betslip.getBets(), betslip.getUser(), betslip.getTotalOdds(), betslip.getTotalStake(), betslip.getToWin(),
               ticketStatus, betslip.getTicket().getBetslip());
        return ticketDao.save(ticket);
    }

}
