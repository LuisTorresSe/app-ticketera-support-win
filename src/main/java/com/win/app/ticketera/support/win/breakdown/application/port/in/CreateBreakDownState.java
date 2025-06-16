package com.win.app.ticketera.support.win.breakdown.application.port.in;

import com.win.app.ticketera.support.win.client.application.port.in.GetClientsByCtoUseCase;

import java.time.Duration;

public class CreateBreakDownState {
   private  GetClientsByCtoUseCase getClientsByCtoUseCase ;
   private Long subticketId;
    private Duration fallTime;
    private String breakdownStatus;
}
