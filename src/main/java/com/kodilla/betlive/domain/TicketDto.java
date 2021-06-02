package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class TicketDto {

    int ticketId;
    List<Type> types;
    User user;
    BigDecimal totalOdds;
    BigDecimal totalStake;
    BigDecimal toWin;
    String ticketStatus;
    Betslip betslip;
}
