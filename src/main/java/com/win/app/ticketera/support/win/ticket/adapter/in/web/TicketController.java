package com.win.app.ticketera.support.win.ticket.adapter.in.web;

import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketCommand;
import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketUseCase;
import com.win.app.ticketera.support.win.ticket.application.port.out.CreateTicketState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketController {
    private final CreateTicketUseCase createTicketUseCase;

    public TicketController(CreateTicketUseCase createTicketUseCase) {
        this.createTicketUseCase = createTicketUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateTicketState> createTicket
            (
                    @RequestBody RequestCreateTicketDto request
            ) {
        CreateTicketCommand command = new CreateTicketCommand(request.type());
        CreateTicketState response =  createTicketUseCase.createTicket(command);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
