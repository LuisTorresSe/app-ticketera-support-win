package com.win.app.ticketera.support.win.ticket.domain;

import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public  class Ticket {
    private Long ticketId;
    private Type type;
    private String codeTicket;
    private Set<Subticket> subTickets;
}
