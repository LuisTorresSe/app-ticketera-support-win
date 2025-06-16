package com.win.app.ticketera.support.win.ticket.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketJpaEntity, Long> {
}
