package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TYPES")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TYPEID", unique = true)
    private int typeId;
    @Column(name = "HOMETEAM")
    private String homeTeam;
    @Column(name = "AWAYTEAM")
    private String awayTeam;
    @Column(name = "EVENTDATE")
    private String eventDate;
    @Column(name = "ODDD")
    private double odd;
    @Column(name = "TYPE")
    private String yourType;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "types")
    private List<Betslip> betslips ;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "JOIN_TICKET_TYPE",
            joinColumns = {@JoinColumn(name = "TYPEID", referencedColumnName = "TYPEID")},
            inverseJoinColumns = {@JoinColumn(name = "TICKETID", referencedColumnName = "TICKETID")}, uniqueConstraints = @UniqueConstraint(columnNames = {
            "TICKETID", "TYPEID" }))

    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", odd=" + odd +
                ", yourType='" + yourType + '\'' +
                ", betslips=" + betslips +
                ", tickets=" + tickets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return typeId == type.typeId && Double.compare(type.odd, odd) == 0 && Objects.equals(homeTeam, type.homeTeam) && Objects.equals(awayTeam, type.awayTeam) && Objects.equals(eventDate, type.eventDate) && Objects.equals(yourType, type.yourType) && Objects.equals(betslips, type.betslips) && Objects.equals(tickets, type.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, homeTeam, awayTeam, eventDate, odd, yourType, betslips, tickets);
    }
}
