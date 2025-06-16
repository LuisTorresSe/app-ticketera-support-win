package com.win.app.ticketera.support.win.ticket.application.port.in;

import com.win.app.ticketera.support.win.ticket.domain.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateTicketCommand {

    private Type type;

    public CreateTicketCommand(Type type) {
        this.type = type;
    }
}
