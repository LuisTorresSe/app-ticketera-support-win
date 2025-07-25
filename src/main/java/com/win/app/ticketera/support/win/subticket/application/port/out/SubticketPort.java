package com.win.app.ticketera.support.win.subticket.application.port.out;

import com.win.app.ticketera.support.win.subticket.domain.Subticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SubticketPort {

    Optional<Subticket> getSubticketById(Long id);

    Subticket saveSubticket(Subticket subticket);

    Optional<List<Subticket>> getSubticketByTicketId(Long ticketId);

    Set<Subticket> getSubticketByCtoAndStatusPending(String cto);
}
