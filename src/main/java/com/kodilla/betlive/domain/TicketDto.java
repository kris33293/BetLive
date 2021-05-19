package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class TicketDto {

    int ticketId;
    List<Bet> bets;
    User user;
    BigDecimal totalOdds, totalStake, toWin;
    TicketStatus ticketStatus;
}
