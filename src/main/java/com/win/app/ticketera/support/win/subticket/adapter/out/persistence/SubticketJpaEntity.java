package com.win.app.ticketera.support.win.subticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.breakdown.adapter.out.persistence.BreakDownJpaEntity;
import com.win.app.ticketera.support.win.subticket.domain.Diagnosis;
import com.win.app.ticketera.support.win.subticket.domain.Report;
import com.win.app.ticketera.support.win.subticket.domain.StatusSubticket;
import com.win.app.ticketera.support.win.ticket.adapter.out.persistence.TicketJpaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "subtickets")
@Data
public class SubticketJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subticketId;

    private String subticketCode;
    private String managerAt;

    @Enumerated(EnumType.STRING)
    private Report report;

    @Enumerated(EnumType.STRING)
    private Diagnosis diagnosis;

    private LocalDateTime createAtEvent;
    private LocalDateTime reportPext;
    private LocalDateTime endAtEvent;
    private LocalDateTime dateStopLabores;
    private LocalDateTime dateStartLabores;

    private Duration stopWork;
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
    @Enumerated(EnumType.STRING)
    private StatusSubticket status;
    private String commentary;

    @OneToMany(mappedBy = "subticket", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<BreakDownJpaEntity> breakDowns;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketJpaEntity ticket;
}
