package com.kodilla.betlive.controller;


import com.kodilla.betlive.domain.*;
import com.kodilla.betlive.mapper.BetMapper;
import com.kodilla.betlive.mapper.BetslipMapper;
import com.kodilla.betlive.mapper.TicketMapper;
import com.kodilla.betlive.service.BetDbService;
import com.kodilla.betlive.service.BetslipDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/betslip")
public class BetslipController {

    private final BetslipMapper betslipMapper;
    public final BetMapper betMapper;
    public final TicketMapper ticketMapper;
    private final BetslipDbService betslipDbService;
    private final BetDbService betDbService;

    @RequestMapping(method = RequestMethod.GET, value = "getALlBets")
    public List<BetDto> getAllBets(int betslipId) {
        List<Bet> bets = betslipDbService.findAllBets(betslipId);
        return betMapper.maptoBetDtoList(bets);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBetslip")
    public BetslipDto createBetslip(BetslipDto betslipDto) {
        Betslip betslip = betslipDbService.createBetslip(betslipMapper.mapToBetslip(betslipDto));
        return  betslipMapper.mapToBetslipDto(betslip);

    }

    @RequestMapping(method = RequestMethod.POST, value = "addBet")
    public void addBet(int betId, int betslipId) {
        Bet bet = betDbService.findById(betId);
        betslipDbService.addBet(betslipId,bet);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBet")
    public void deleteBet(int betId, int betslipId) {
        Bet bet = betDbService.findById(betId);
        betslipDbService.deleteBet(betslipId,bet);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTicket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketDto createTicket(BetslipDto betslipDto) {
        return ticketMapper.mapToTicketDto(betslipDbService.createTicket(betslipMapper.mapToBetslip(betslipDto)));
    }

}
