package com.win.app.ticketera.support.win.ticket.adapter.out.config;

import com.win.app.ticketera.support.win.ticket.adapter.out.persistence.TicketPersistenceAdapter;
import com.win.app.ticketera.support.win.ticket.adapter.out.persistence.TicketRepository;
import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketUseCase;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import com.win.app.ticketera.support.win.ticket.application.service.CreateTicketService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfig {

    @Bean
    public TicketPort getTicketPort(TicketRepository ticketRepository) {
        return new TicketPersistenceAdapter(ticketRepository);
    }

    @Bean
    public CreateTicketUseCase createTicketUseCase(TicketPort ticketPort) {
        return new CreateTicketService(ticketPort);
    }




}
