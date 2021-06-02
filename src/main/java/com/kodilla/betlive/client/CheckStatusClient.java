package com.kodilla.betlive.client;

import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.Type;
import com.kodilla.betlive.domain.User;

import java.util.List;
import java.util.Set;

public class CheckStatusClient {



    public Ticket checkTicket(Ticket ticket, List<Result> resultList) {
        int wins = 0;
        List<Type> checkingTypes = ticket.getTypes();
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
            User user = ticket.getUser();
            user.setBalance(user.getBalance().add(ticket.getToWin()));
        }  else ticket.setTicketStatus("Pending");

        return ticket;
    }
}
