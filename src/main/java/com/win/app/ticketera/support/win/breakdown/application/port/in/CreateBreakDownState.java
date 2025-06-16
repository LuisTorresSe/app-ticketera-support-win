package com.win.app.ticketera.support.win.breakdown.application.port.in;


import com.win.app.ticketera.support.win.client.application.port.in.GetClientByCtoState;
import lombok.Setter;

import java.time.Duration;


@Setter
public class CreateBreakDownState {
   private Long subticketId;
   private Duration fallTime;
   private String breakdownStatus;
   private GetClientByCtoState getClientByCtoState;
}
