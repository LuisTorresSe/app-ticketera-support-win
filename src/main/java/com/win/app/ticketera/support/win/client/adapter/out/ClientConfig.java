package com.win.app.ticketera.support.win.client.adapter.out;

import com.win.app.ticketera.support.win.client.adapter.out.persistence.ClientPersistenceAdapter;
import com.win.app.ticketera.support.win.client.adapter.out.persistence.ClientRepository;
import com.win.app.ticketera.support.win.client.application.port.in.GetClientsByCtoUseCase;
import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.client.application.service.GetClientsByCtoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

@Bean
    public ClientPort clientPort(ClientRepository clientRepository){
        return new ClientPersistenceAdapter(clientRepository);
}

@Bean
    public GetClientsByCtoUseCase getClientsByCto(ClientPort clientPort){
    return new GetClientsByCtoService(clientPort);
}
}
