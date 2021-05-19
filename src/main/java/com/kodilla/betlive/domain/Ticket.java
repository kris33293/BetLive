package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "TICKETS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "TICKETID", unique = true)
    Integer ticketId;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
            name = "JOIN_TICKET_BET",
            joinColumns = {@JoinColumn(name = "JOIN_TICKETID", referencedColumnName = "TICKETID")},
            inverseJoinColumns = {@JoinColumn(name = "JOIN_BETID", referencedColumnName = "BETID")}
    )
    List<Bet> bets;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "USERID")
    User user;

    @Column(name = "TOTALODDS")
    BigDecimal totalOdds;
    @Column(name = "TOTALSTAKE")
    BigDecimal totalStake;
    @Column(name = "TOWIN")
    BigDecimal toWin;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "TICKETSTATUSID")
    TicketStatus ticketStatus;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "BETSLIPID")
    Betslip betslip;

}
