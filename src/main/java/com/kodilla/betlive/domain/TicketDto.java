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
    Set<Type> types;
    User user;
    BigDecimal totalOdds, totalStake, toWin;
    String ticketStatus;
}
