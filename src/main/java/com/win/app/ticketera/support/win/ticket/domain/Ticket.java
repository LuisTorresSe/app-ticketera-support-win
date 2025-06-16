package com.win.app.ticketera.support.win.ticket.domain;


import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import lombok.Data;
import java.util.Set;
import java.util.UUID;

@Data
public  class Ticket {
    private Long TicketId;
    private UUID TicketUq;
    private String codTicket;
    private Set<Subticket> subTickets;
}
