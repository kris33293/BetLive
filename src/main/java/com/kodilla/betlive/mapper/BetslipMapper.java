package com.kodilla.betlive.mapper;

import com.kodilla.betlive.domain.Betslip;
import com.kodilla.betlive.domain.BetslipDto;
import org.springframework.stereotype.Service;

@Service
public class BetslipMapper {

    public BetslipDto mapToBetslipDto(final Betslip betslip) {
        BetslipDto betslipDto = new BetslipDto();
        betslipDto.setBetslipId(betslip.getBetslipId());
        betslipDto.setBets(betslip.getBets());
        betslipDto.setUser(betslip.getUser());
        betslipDto.setTotalOdds(betslip.getTotalOdds());
        betslipDto.setTotalStake(betslip.getTotalStake());
        betslipDto.setToWin(betslip.getToWin());
        betslipDto.setTicket(betslip.getTicket());
        return betslipDto;
    }

    public Betslip mapToBetslip(final BetslipDto betslipDto) {
        Betslip betslip = new Betslip();
        betslip.setBetslipId(betslipDto.getBetslipId());
        betslip.setBets(betslipDto.getBets());
        betslip.setTotalOdds(betslipDto.getTotalOdds());
        betslip.setTotalStake(betslipDto.getTotalStake());
        betslip.setToWin(betslipDto.getToWin());
        betslip.setTicket(betslip.getTicket());
        betslip.setUser(betslip.getUser());
        return betslip;
    }
}
