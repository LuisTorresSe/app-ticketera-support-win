package com.win.app.ticketera.support.win.subticket.domain;

import com.win.app.ticketera.support.win.breakdown.domain.BreakDown;
import com.win.app.ticketera.support.win.managerAt.domain.ManagerAt;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;
import com.win.app.ticketera.support.win.ticket.domain.Type;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subticket {

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
    private StatusSubticket statusSubticket;
    private String commentary;
    private String responsable;
    private Set<BreakDown> breakDowns;
    private Ticket ticket;


    private void calculateTimeWork(){
            setStopWork(Duration.between(dateStartLabores,dateStopLabores));
    }

    private void calculateTimeEvent(){
            setTimeEvent(Duration.between( createAtEvent,endAtEvent));
    }


    private void calculateTimeSolutionsEventPext(){
        setTimeSolutionsEventPext(Duration.between(reportPext,endAtEvent));
    }
    private void calculateTimeReportPext(){
        setTimeReportPext(Duration.between(createAtEvent,reportPext));
    }

}
