package com.win.app.ticketera.support.win.ticket.application.service;

import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketCommand;
import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketUseCase;
import com.win.app.ticketera.support.win.ticket.application.port.out.CreateTicketState;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service
public class CreateTicketService implements CreateTicketUseCase {

    private final TicketPort ticketPort;

    public CreateTicketService(TicketPort ticketPort) {
        this.ticketPort = ticketPort;
    }

    @Override
    public CreateTicketState createTicket(CreateTicketCommand createTicketCommand) {

        Ticket newTicket = new Ticket();
        newTicket.setType(createTicketCommand.getType());

        Ticket saveTicket =  ticketPort.save(newTicket);

        String chartInitialType = saveTicket.getType().name().substring(0, 1).toUpperCase();
        String codeTicketFormat = String.format("W-CR-%05d-%s", saveTicket.getTicketId(), chartInitialType);

        saveTicket.setCodeTicket(codeTicketFormat);

        Ticket updateTicket = ticketPort.update(saveTicket);

        CreateTicketState createTicketState = new CreateTicketState();
        createTicketState.setTicketCode(updateTicket.getCodeTicket());
        createTicketState.setTicketId(updateTicket.getTicketId());
        createTicketState.setTicketCode(updateTicket.getCodeTicket());
        createTicketState.setType(updateTicket.getType());

    return createTicketState;
    }
}
