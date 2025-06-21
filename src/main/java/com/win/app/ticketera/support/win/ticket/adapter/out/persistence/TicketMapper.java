package com.win.app.ticketera.support.win.ticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketMapper;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;

import java.util.HashSet;
import java.util.stream.Collectors;

public class TicketMapper {

    public static Ticket toDomain(TicketJpaEntity ticketJpa) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketJpa.getTicketId());
        ticket.setType(ticketJpa.getType());
        ticket.setCodeTicket(ticketJpa.getTicketCode());

        if (ticketJpa.getSubtickets() != null) {
            // Copiar la colección para evitar ConcurrentModificationException
            var subticketsCopy = new HashSet<>(ticketJpa.getSubtickets());

            ticket.setSubTickets(
                    subticketsCopy.stream()
                            .map(SubticketMapper::toDomainWithoutTicket)
                            .collect(Collectors.toSet())
            );
        }

        return ticket;
    }

    public static Ticket toDomainWithoutSubticket(TicketJpaEntity ticketJpa) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketJpa.getTicketId());
        ticket.setType(ticketJpa.getType());
        ticket.setCodeTicket(ticketJpa.getTicketCode());
        ticket.setSubTickets(new HashSet<>());
        return ticket;
    }

    public static TicketJpaEntity toJpa(Ticket ticket) {
        TicketJpaEntity ticketJpa = new TicketJpaEntity();
        ticketJpa.setTicketId(ticket.getTicketId());
        ticketJpa.setTicketCode(ticket.getCodeTicket());
        ticketJpa.setType(ticket.getType());

        if (ticket.getSubTickets() != null) {
            ticketJpa.setSubtickets(
                    ticket.getSubTickets().stream()
                            .map(SubticketMapper::toJpaWithoutTicket)
                            .collect(Collectors.toSet())
            );
        }

        return ticketJpa;
    }

    public static TicketJpaEntity toJpaWithoutSubticket(Ticket ticket) {
        TicketJpaEntity jpa = new TicketJpaEntity();
        jpa.setTicketId(ticket.getTicketId());
        jpa.setType(ticket.getType());
        jpa.setTicketCode(ticket.getCodeTicket());
        return jpa;
    }
}
