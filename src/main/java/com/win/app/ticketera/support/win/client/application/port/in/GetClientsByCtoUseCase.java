package com.win.app.ticketera.support.win.client.application.port.in;

import com.win.app.ticketera.support.win.client.domain.Client;

import java.util.List;

public interface GetClientsByCtoUseCase {

    List<GetClientByCtoState> getClients(String cto);
}
