package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface TicketDao extends CrudRepository<Ticket, Integer> {

    @Override
    Ticket save(Ticket ticket);

    List<Ticket> findAll();

    List<Ticket> findByUserUserId(int userId);

    Ticket findByTicketId(int ticketId);

}
