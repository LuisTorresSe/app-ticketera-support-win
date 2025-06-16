package com.win.app.ticketera.support.win.ticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketJpaEntity;
import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketMapper;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;

import java.util.stream.Collectors;

public class TicketMapper {

    public static Ticket toDomain(TicketJpaEntity ticketJpaEntity){
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketJpaEntity.getTicketId());
        ticket.setType(ticketJpaEntity.getType());
        ticket.setCodeTicket(ticketJpaEntity.getTicketCode());

        ticket.setSubTickets(
                ticketJpaEntity.getSubtickets().stream().map(
                        subticketJpaEntity -> SubticketMapper.toDomain(subticketJpaEntity)
                ).collect(Collectors.toSet())
        );

        return ticket;
    }
    public static TicketJpaEntity toJpa(Ticket ticket){
        TicketJpaEntity ticketJpaEntity = new TicketJpaEntity();
        ticketJpaEntity.setTicketId(ticket.getTicketId());
        ticketJpaEntity.setType(ticket.getType());
        ticketJpaEntity.setTicketCode(ticket.getCodeTicket());
        ticketJpaEntity.setTicketId(ticket.getTicketId());
        ticketJpaEntity.setSubtickets(
                ticket.getSubTickets().stream().map(subticket->SubticketMapper.toJpa(subticket)
                ).collect(Collectors.toSet())
        );
        return ticketJpaEntity;
    }
}
