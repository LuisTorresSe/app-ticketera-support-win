package com.win.app.ticketera.support.win.subticket.application.port.in;

import com.win.app.ticketera.support.win.subticket.domain.Subticket;

public interface CreateSubticketUseCase {

    Subticket createSubticket(CreateSubticketCommand createSubticketCommand);
}
