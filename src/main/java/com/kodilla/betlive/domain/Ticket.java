package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    int ticketId;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "tickets")
    List<Type> types;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "USERID")
    User user;

    @Column(name = "TOTALODDS")
    BigDecimal totalOdds;
    @Column(name = "TOTALSTAKE")
    BigDecimal totalStake;
    @Column(name = "TOWIN")
    BigDecimal toWin;


    @JoinColumn(name = "TICKETSTATUS")
    String ticketStatus;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "BETSLIPID")
    Betslip betslip;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", types=" + types +
                ", user=" + user +
                ", totalOdds=" + totalOdds +
                ", totalStake=" + totalStake +
                ", toWin=" + toWin +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", betslip=" + betslip +
                '}';
    }
}
