package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BetDto {

    private int betId;
    private double oddHome;
    private double oddAway;
    private double oddDraw;
    private String homeTeam;
    private String awayTeam;
    private Date eventDate;

}
