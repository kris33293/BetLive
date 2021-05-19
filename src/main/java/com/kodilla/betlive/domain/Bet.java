package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BETS")
public class Bet {

    @Id
    @GeneratedValue
    @Column(name = "BETID", unique = true)
    private int betId;
    @Column(name = "ODDHOME")
    private double oddHome;
    @Column(name = "ODDAWAY")
    private double oddAway;
    @Column(name = "ODDDRAW")
    private double oddDraw;
    @Column(name = "HOMETEAM")
    private String homeTeam;
    @Column(name = "AWAYTEAM")
    private String awayTeam;
    @Column(name = "EVENTDATE")
    private Date eventDate;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST}, mappedBy = "bets")
    private List<Ticket> tickets = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST}, mappedBy = "bets")
    private List<Betslip> betslips = new ArrayList<>();

}
