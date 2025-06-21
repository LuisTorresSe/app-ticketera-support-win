package com.win.app.ticketera.support.win.ticket.application.port.in;

import com.win.app.ticketera.support.win.ticket.application.port.out.CreateTicketState;

public interface CreateTicketUseCase {

    CreateTicketState createTicket(CreateTicketCommand createTicketCommand);

}
