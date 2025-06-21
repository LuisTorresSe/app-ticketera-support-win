package com.win.app.ticketera.support.win.breakdown.application.service;

import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownCommand;
import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownState;
import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownUseCase;
import com.win.app.ticketera.support.win.breakdown.application.port.in.BreakDownMapperState;
import com.win.app.ticketera.support.win.breakdown.application.port.out.BreakDownPort;
import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.client.application.exception.ClientsNotFound;
import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.subticket.application.exception.NotFoundSubticket;
import com.win.app.ticketera.support.win.subticket.application.port.out.SubticketPort;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public class CreateBreakDownService implements CreateBreakDownUseCase {

    private final ClientPort clientPort;
    private final SubticketPort subticketPort;
    private final BreakDownPort breakDownPort;

    public CreateBreakDownService(ClientPort clientPort,
                                  SubticketPort subticketPort,
                                  BreakDownPort breakDownPort) {
        this.clientPort = clientPort;
        this.subticketPort = subticketPort;
        this.breakDownPort = breakDownPort;
    }

    @Override
    public CreateBreakDownState createBreakDown(CreateBreakDownCommand breakDownCommand) {
        Long clientId = breakDownCommand.getClientId();
        Long subticketId = breakDownCommand.getSubticketId();

        clientPort.getClientById(clientId).orElseThrow(
                ()-> new ClientsNotFound("Client not found with id: " + clientId)
        );

        subticketPort.getSubticketById(subticketId).orElseThrow(
                ()-> new NotFoundSubticket("Subticket not found with id: " + subticketId)
        );

        BreakDown newBreakDown = breakDownPort.createBreakDown(breakDownCommand);

        return BreakDownMapperState.createBreakDownState(newBreakDown);
    }
}
