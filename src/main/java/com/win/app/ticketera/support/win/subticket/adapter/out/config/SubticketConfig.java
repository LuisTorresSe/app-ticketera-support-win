package com.win.app.ticketera.support.win.subticket.adapter.out.config;

import com.win.app.ticketera.support.win.client.adapter.out.persistence.ClientRepository;
import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketPersistenceAdapter;
import com.win.app.ticketera.support.win.subticket.adapter.out.persistence.SubticketRepository;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketUseCase;
import com.win.app.ticketera.support.win.subticket.application.port.out.SubticketPort;
import com.win.app.ticketera.support.win.subticket.application.service.CreateSubticketService;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubticketConfig {

    @Bean
    public SubticketPort subticketPort(SubticketRepository subticketRepository) {
        return new SubticketPersistenceAdapter(subticketRepository);

    }
    @Bean
    public CreateSubticketUseCase createSubticketUseCase(SubticketPort subticketPort,
                                                         TicketPort ticketPort,
                                                         ClientPort clientPort) {
        return new CreateSubticketService(subticketPort, ticketPort, clientPort);
    }
}
