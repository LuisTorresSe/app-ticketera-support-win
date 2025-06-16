package com.win.app.ticketera.support.win.ticket.application.port.out;

import com.win.app.ticketera.support.win.ticket.domain.Type;
import lombok.Data;
import lombok.Setter;

@Data
public class CreateTicketState{
    private Long ticketId;
    private String ticketCode;
    private Type type;
}
