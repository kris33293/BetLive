package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetslipDto {

    int betslipId;
    Set<Type> types;
    User user;
    BigDecimal totalOdds, totalStake, toWin;
    Ticket ticket;
}
