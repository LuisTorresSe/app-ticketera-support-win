package com.win.app.ticketera.support.win.breakdown.application.port.out;

import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownCommand;
import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownState;

public interface BreakDownPort {

    CreateBreakDownState createBreakDown(CreateBreakDownCommand breakDownCommand);
}
