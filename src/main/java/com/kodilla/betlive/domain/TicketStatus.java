package com.kodilla.betlive.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TICKETSTATUS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketStatus {

    @Id
    @GeneratedValue
    @Column(name = "TICKETSTATUSID", unique = true)
    int ticketStatusId;

    String status;

    @OneToMany(
            targetEntity = Ticket.class,
            mappedBy = "ticketStatus",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    List<Ticket> tickets = new ArrayList<>();
}
