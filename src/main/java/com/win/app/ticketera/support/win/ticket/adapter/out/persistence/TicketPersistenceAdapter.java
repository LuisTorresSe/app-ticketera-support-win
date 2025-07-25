package com.win.app.ticketera.support.win.ticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.ticket.application.port.in.CreateTicketCommand;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;

import java.util.Optional;

public class TicketPersistenceAdapter implements TicketPort {
    private final TicketRepository ticketRepository;

    public TicketPersistenceAdapter(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {

        TicketJpaEntity saveTicket =  ticketRepository.save(TicketMapper.toJpa(ticket));



        return TicketMapper.toDomain(saveTicket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        TicketJpaEntity saveTicket =  ticketRepository.save(TicketMapper.toJpa(ticket));
        return TicketMapper.toDomain(saveTicket);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        System.out.println("esto es el id de ticket "+ id);
        return ticketRepository.findById(id)
                .map(TicketMapper::toDomainWithoutSubticket);
    }

}
