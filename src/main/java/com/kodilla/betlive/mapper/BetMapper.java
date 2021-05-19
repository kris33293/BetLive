package com.kodilla.betlive.mapper;

import com.kodilla.betlive.domain.Bet;
import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.BetDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BetMapper {

    public BetDto mapToBetDto(final Bet bet) {
        BetDto betDto = new BetDto(
                bet.getBetId(),
                bet.getOddHome(),
                bet.getOddAway(),
                bet.getOddDraw(),
                bet.getHomeTeam(),
                bet.getAwayTeam(),
                bet.getEventDate());
        return betDto;
    }

    public Bet mapToBet(final BetDto betDto) {
        Bet bet = new Bet();
        bet.setBetId(betDto.getBetId());
        bet.setOddHome(betDto.getOddHome());
        bet.setOddAway(betDto.getOddAway());
        bet.setOddDraw(betDto.getOddDraw());
        bet.setHomeTeam(betDto.getHomeTeam());
        bet.setAwayTeam(betDto.getAwayTeam());
        bet.setEventDate(betDto.getEventDate());
        return bet;
    }

    public List<BetDto> maptoBetDtoList(final List<Bet> betList) {
        return betList.stream()
                .map(this::mapToBetDto)
                .collect(Collectors.toList());
    }

    public List<Bet> maptoBetList(final List<BetDto> betList) {
        return betList.stream()
                .map(this::mapToBet)
                .collect(Collectors.toList());
    }

}
