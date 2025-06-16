package com.win.app.ticketera.support.win.breakdown.application.port.out;

import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownCommand;
import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownState;
import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;

public interface BreakDownPort {

    BreakDown createBreakDown(CreateBreakDownCommand breakDownCommand);
}
