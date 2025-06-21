package com.win.app.ticketera.support.win.ticket.application.port.out;

import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketCommand;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;

import java.util.Optional;

public interface TicketPort {
    Ticket save(Ticket ticket);
    Ticket update(Ticket ticket);
    Optional<Ticket> findById(Long id);
}
