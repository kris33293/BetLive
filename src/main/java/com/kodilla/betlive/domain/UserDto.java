package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {

    private int userId;
    private String userName;
    private BigDecimal balance;
    private List<Betslip> betslips;
    private List<Ticket> tickets;
}
