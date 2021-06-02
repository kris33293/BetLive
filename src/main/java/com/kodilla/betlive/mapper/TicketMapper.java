package com.kodilla.betlive.mapper;

import com.kodilla.betlive.domain.Ticket;
import com.kodilla.betlive.domain.TicketDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketMapper {

    public Ticket mapToTicket(final TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketDto.getTicketId());
        ticket.setTypes(ticketDto.getTypes());
        ticket.setUser(ticketDto.getUser());
        ticket.setTotalOdds(ticketDto.getTotalOdds());
        ticket.setTotalStake(ticketDto.getTotalStake());
        ticket.setToWin(ticketDto.getToWin());
        ticket.setTicketStatus(ticketDto.getTicketStatus());
        return ticket;
    }

    public TicketDto mapToTicketDto(final Ticket ticket) {
        TicketDto ticketDto = new TicketDto(
                ticket.getTicketId(),
                ticket.getTypes(),
                ticket.getUser(),
                ticket.getTotalOdds(),
                ticket.getTotalStake(),
                ticket.getToWin(),
                ticket.getTicketStatus(),
                ticket.getBetslip());

        return ticketDto;
    }

    public List<TicketDto> maptoTicketDtoList(final List<Ticket> cartList) {
        return cartList.stream()
                .map(this::mapToTicketDto)
                .collect(Collectors.toList());
    }

}
