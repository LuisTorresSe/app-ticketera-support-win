package com.win.app.ticketera.support.win.breakdown.application.port.in;

import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;

public interface CreateBreakDownUseCase {

    CreateBreakDownState createBreakDown(CreateBreakDownCommand breakDown);
}
