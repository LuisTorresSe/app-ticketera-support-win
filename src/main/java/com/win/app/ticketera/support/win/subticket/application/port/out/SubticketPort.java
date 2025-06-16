package com.win.app.ticketera.support.win.subticket.application.port.out;

import com.win.app.ticketera.support.win.subticket.domain.Subticket;

import java.util.Optional;

public interface SubticketPort {

    Optional<Subticket> getSubticketById(Long id);
}
