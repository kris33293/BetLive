package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RESULTS")
public class Result {

    @Id
    @GeneratedValue
    @Column(name = "RESULTID", unique = true)
    private int resultId;

    @Column(name = "RESULT")
    private String result;

    @Column(name = "HOMETEAM")
    private String homeTeam;

    @Column(name = "AWAYEAM")
    private String awayTeam;

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
                ", result='" + result + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                '}';
    }
}
