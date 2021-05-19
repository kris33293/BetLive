package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "LEAGUES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class League {

    @Id
    @GeneratedValue
    @Column(name = "LEAGUEID", unique = true)
    int leagueId;
    @Column(name = "LEAGUENAME")
    String leagueName;
    @Column(name = "APILEAGUENAME")
    String apiLeagueName;
}
