package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetslipDto {

    int betslipId;
    List<Bet> bets;
    User user;
    BigDecimal totalOdds, totalStake, toWin;
    Ticket ticket;
}
