package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USERID", unique = true)
    private int userId;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "BALANCE")
    private BigDecimal balance;

    @OneToMany(
            targetEntity = Ticket.class,
            mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(
            targetEntity = Betslip.class,
            mappedBy = "user",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Betslip> betslips = new ArrayList<>();


}
