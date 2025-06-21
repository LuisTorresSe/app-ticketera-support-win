package com.win.app.ticketera.support.win.subticket.adapter.in.web;

import com.win.app.ticketera.support.win.breakdown.application.port.in.CreateBreakDownCommand;
import com.win.app.ticketera.support.win.subticket.domain.Diagnosis;
import com.win.app.ticketera.support.win.subticket.domain.Report;
import com.win.app.ticketera.support.win.subticket.domain.StatusSubticket;
import jakarta.annotation.Nullable;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public record RequestCreateSubticketDto(
        Long ticketId,

        String managerAt,
        Report report,
        Diagnosis diagnosis,

        LocalDateTime createAtEvent,
        LocalDateTime reportPext,
        LocalDateTime endAtEvent,
        LocalDateTime dateStopLabores,
        LocalDateTime dateStartLabores,

        Duration stopWork,
        Duration timeEvent,
        Duration timeAffected,
        Duration timeSolutionsEventPext,
        Duration timeReportPext,

        Boolean unavailability,
        String nodeAffected,
        String olt,
        Integer card,
        Integer port,
        String ctoAffected,
        String city,
        String causeProblem,
        Integer countClient,
        Boolean badPraxis,
        String solutions,
        String closeTicketmasterAt,
        StatusSubticket status,
        String commentary,
        String responsable,
        @Nullable
        Set<CreateBreakDownCommand> breakDownCommands) {
}
