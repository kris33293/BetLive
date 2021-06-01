package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class TypeDto {


    int typeId;
    String homeTeam;
    String awayTeam;
    String eventDate;
    double odd;
    String yourType;
    Set<Betslip> betslips;
    Set<Ticket> tickets;
}
