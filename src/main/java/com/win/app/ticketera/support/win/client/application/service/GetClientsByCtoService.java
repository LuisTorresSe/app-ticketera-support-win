package com.win.app.ticketera.support.win.client.application.service;

import com.win.app.ticketera.support.win.client.application.exception.ClientsNotFound;
import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import com.win.app.ticketera.support.win.client.application.port.in.GetClientsByCtoUseCase;
import com.win.app.ticketera.support.win.client.application.port.out.ClientMapperState;
import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.client.domain.Client;
import java.util.List;


public class GetClientsByCtoService implements GetClientsByCtoUseCase {
    private final ClientPort clientPort;
    public GetClientsByCtoService(ClientPort clientPort) {
        this.clientPort = clientPort;
    }

    @Override
    public List<GetClientByCtoState> getClients(String cto) {

        List<Client> clients =  clientPort.getClientsByCto(cto.toUpperCase()).orElseThrow(
                () -> new ClientsNotFound("No Exits clients with cto: " + cto)
        );

        System.out.println(clients);

        return clients.stream().map(
                ClientMapperState::toClientByCtoState
        ).toList();
    }
}
