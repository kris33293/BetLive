package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketDao extends CrudRepository<Ticket, Integer> {

    @Override
    Ticket save (Ticket ticket);

    List<Ticket> findAll();

    List<Ticket> findByUserUserId(int userId);

    Ticket findByTicketId(int ticketId);

}
