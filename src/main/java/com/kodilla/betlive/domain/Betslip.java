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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "JOIN_BETSLIP_TYPE",
            joinColumns = {@JoinColumn(name = "BETSLIPID", referencedColumnName = "BETSLIPID")},
            inverseJoinColumns = {@JoinColumn(name = "TYPEID", referencedColumnName = "TYPEID")}, uniqueConstraints = @UniqueConstraint(columnNames = {
            "BETSLIPID", "TYPEID" }))

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

    @OneToOne(cascade = CascadeType.PERSIST)
    Ticket ticket;

    @Override
    public String toString() {
        return "Betslip{" +
                "betslipId=" + betslipId +
                ", types=" + types +
                ", user=" + user +
                ", totalOdds=" + totalOdds +
                ", totalStake=" + totalStake +
                ", toWin=" + toWin +
                ", ticket=" + ticket +
                '}';
    }
}
