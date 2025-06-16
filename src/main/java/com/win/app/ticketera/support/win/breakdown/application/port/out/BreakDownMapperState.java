package com.win.app.ticketera.support.win.breakdown.application.port.out;

import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownState;
import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import com.win.app.ticketera.support.win.client.application.port.out.ClientMapperState;

public class BreakDownMapperState {

    public static CreateBreakDownState createBreakDownState(BreakDown breakDown) {
        CreateBreakDownState toCreateBreakDownState = new CreateBreakDownState();
        toCreateBreakDownState.setSubticketId(breakDown.getSubticket().getSubticketId());
        toCreateBreakDownState.setFallTime(breakDown.getFallTime());
        toCreateBreakDownState.setGetClientByCtoState(ClientMapperState.toClientByCtoState(breakDown.getClient()));
        return toCreateBreakDownState;
    }
}
