package com.kodilla.betlive.domain;

import org.springframework.data.repository.CrudRepository;

public interface TicketStatusDao extends CrudRepository<TicketStatus, Integer> {
    @Override
    TicketStatus save (TicketStatus ticketStatus);

    TicketStatus findTicketStatusByTicketStatusId(int ticketStatusId);
}
