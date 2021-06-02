package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public static class BetBuilder {
        private int betId;
        private double oddHome;
        private double oddAway;
        private double oddDraw;
        private String homeTeam;
        private String awayTeam;
        private Date eventDate;

        public BetBuilder betId(int betId){
            this.betId = betId;
            return this;
        }

        public BetBuilder oddHome(double oddHome){
            this.oddHome = oddHome;
            return this;
        }

        public BetBuilder oddAway(double oddAway){
            this.oddAway = oddAway;
            return this;
        }

        public BetBuilder oddDraw(double oddDraw){
            this.oddDraw = oddDraw;
            return this;
        }

        public BetBuilder homeTeam(String homeTeam){
            this.homeTeam = homeTeam;
            return this;
        }

        public BetBuilder awayTeam(String awayTeam){
            this.awayTeam = awayTeam;
            return this;
        }

        public BetBuilder eventDate(Date eventDate){
            this.eventDate = eventDate;
            return this;
        }

        public Bet build(){
            return new Bet(betId,oddHome,oddAway,oddDraw,homeTeam,awayTeam,eventDate);
        }

    }
    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
                ", oddHome=" + oddHome +
                ", oddAway=" + oddAway +
                ", oddDraw=" + oddDraw +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
