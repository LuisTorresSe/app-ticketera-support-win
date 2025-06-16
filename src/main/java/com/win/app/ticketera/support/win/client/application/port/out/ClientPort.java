package com.win.app.ticketera.support.win.client.application.port.out;

import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import com.win.app.ticketera.support.win.client.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientPort {
    Optional<List<Client>> getClientsByCto (String cto);

    Optional<Client> getClientById(Long clientId);
}
