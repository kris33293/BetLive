package com.kodilla.betlive.sheduler;

import com.kodilla.betlive.client.CheckStatusClient;
import com.kodilla.betlive.controller.ResultsController;
import com.kodilla.betlive.domain.Result;
import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.service.ResultDbService;
import com.kodilla.betlive.service.TicketDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CheckTicketsSheduler {

    CheckStatusClient checkStatusClient;
    TicketDbService ticketDbService;
    ResultsController resultsController;
    ResultDbService resultDbService;

    @Scheduled(cron = "0 0 0 * * * " )
    public void checkTicketStatus(){
        List<Ticket> tickets = ticketDbService.findAllTickets();
        resultsController.savePremierleagueResults();
        List<Result> results = resultDbService.findAll();
        for (Ticket ticket : tickets) {
            checkStatusClient.checkTicket(ticket,results);
        }

    }
}
