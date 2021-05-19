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
@Table(name = "BETSLIPS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Betslip {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "BETSLIPID", unique = true)
    Integer betslipId;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "JOIN_BETSLIP_BET",
            joinColumns = {@JoinColumn(name = "BETSLIPID", referencedColumnName = "BETSLIPID")},
            inverseJoinColumns = {@JoinColumn(name = "BETID", referencedColumnName = "BETID")}
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

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name = "TICKETID")
    Ticket ticket;
}
