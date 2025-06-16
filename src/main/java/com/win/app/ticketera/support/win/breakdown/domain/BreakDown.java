package com.win.app.ticketera.support.win.breakdown.domain;

import com.win.app.ticketera.support.win.client.domain.Client;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class BreakDown {
    Long breakDownId;
    Client client;
    Subticket subticket;
    Duration fallTime;
    String breakDownStatus;


    Duration setFallTime(Duration fallTime) {
        LocalDateTime startAtEvent = subticket.getCreateAtEvent();
        LocalDateTime now = LocalDateTime.now();
        return Duration.between(startAtEvent, now);
    }


}
