package com.kodilla.betlive.client;

import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.Type;

import java.util.List;
import java.util.Set;

public class CheckStatusClient {

    private Ticket ticket;

    private List<Result> resultList;

    public CheckStatusClient(Ticket ticket, List<Result> resultList) {
        this.ticket = ticket;
        this.resultList = resultList;
    }

    public Ticket checkTicket() {
        int wins = 0;
        Set<Type> checkingTypes = ticket.getTypes();
        int size = checkingTypes.size();

        for (Type type : checkingTypes) {

            for (Result result : resultList) {
                if (result.getAwayTeam().equals(type.getAwayTeam()) && (result.getHomeTeam().equals(type.getHomeTeam()))) {
                    if (result.getResult().equals(type.getYourType())) {
                        wins++;
                    }
                }

            }

        }

        if (wins == size) {
            ticket.setTicketStatus("Win");
        } else ticket.setTicketStatus("Pending");

        return ticket;
    }
}
