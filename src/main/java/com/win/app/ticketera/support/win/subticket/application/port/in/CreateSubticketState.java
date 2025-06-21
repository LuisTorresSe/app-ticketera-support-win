package com.win.app.ticketera.support.win.subticket.application.port.in;

import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.subticket.domain.Diagnosis;
import com.win.app.ticketera.support.win.subticket.domain.Report;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;
import lombok.Builder;


import java.time.Duration;
import java.time.LocalDateTime;

@Builder

public class CreateSubticketState {
    private Long subticketId;
    private String subticketCode;
    private String managerAt;
    private Report report;
    private Diagnosis diagnosis;

    private LocalDateTime createAtEvent;
    private LocalDateTime reportPext;
    private LocalDateTime endAtEvent;
    private LocalDateTime dateStopLabores;
    private LocalDateTime dateStartLabores;

    private Duration stopWork; // preguntar que pasaria si se demoran en atender 2 dias no aceptaria ese formato locatime
    private Duration timeEvent;
    private Duration timeAffected;
    private Duration timeSolutionsEventPext;
    private Duration timeReportPext;

    private Boolean unavailability;
    private String nodeAffected;
    private String olt;
    private Integer card;
    private Integer port;
    private String ctoAffected;
    private String city;
    private String causeProblem;
    private Integer countClient;
    private Boolean badPraxis;
    private String solutions;
    private String closeTicketmasterAt;
    private String status;
    private String commentary;
    private String responsable;
    private Ticket ticket;
}
