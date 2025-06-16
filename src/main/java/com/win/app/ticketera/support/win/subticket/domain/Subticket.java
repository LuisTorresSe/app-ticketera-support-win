package com.win.app.ticketera.support.win.subticket.domain;

import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.managerAt.domain.ManagerAt;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class Subticket {
    private Long subticketId;
    private UUID subticketUQ;
    private String subticketCode;
    private Type type;
    private ManagerAt managerAt;
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
    private Duration timeSolutionsEvent;
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

    private Set<BreakDown> breakDowns;


    private void calculateTimeWork(){}
    private void calculateTimeEvent(){}
    private void calculateTimeAffected(){}
    private void calculateTimeSolutionsEvent(){}
    private void calculateTimeReportPext(){}

}
