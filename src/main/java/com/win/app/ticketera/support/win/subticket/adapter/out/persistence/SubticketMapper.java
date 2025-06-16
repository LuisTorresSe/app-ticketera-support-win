package com.win.app.ticketera.support.win.subticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.breakdown.adapter.out.persistence.BreakDownMapper;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;

import java.util.stream.Collectors;

public class SubticketMapper {

    public static Subticket toDomain(SubticketJpaEntity entity) {

        Subticket domain = new Subticket();
        /* — identificadores y valores simples — */
        domain.setSubticketId(entity.getSubticketId());
        domain.setSubticketCode(entity.getSubticketCode());
        domain.setStatus(entity.getStatus());
        domain.setCommentary(entity.getCommentary());

        /* — value objects / enums — */
        domain.setManagerAt(entity.getManagerAt());     // adapta si ManagerAt usa factory
        domain.setReport(entity.getReport());                         // asumo mismo enum/clase
        domain.setDiagnosis(entity.getDiagnosis());

        /* — fechas y duraciones — */
        domain.setCreateAtEvent(entity.getCreateAtEvent());
        domain.setReportPext(entity.getReportPext());
        domain.setEndAtEvent(entity.getEndAtEvent());
        domain.setDateStopLabores(entity.getDateStopLabores());
        domain.setDateStartLabores(entity.getDateStartLabores());

        domain.setStopWork(entity.getStopWork());
        domain.setTimeEvent(entity.getTimeEvent());
        domain.setTimeAffected(entity.getTimeAffected());
        domain.setTimeSolutionsEvent(entity.getTimeSolutionsEvent());
        domain.setTimeReportPext(entity.getTimeReportPext());

        /* — campos misceláneos — */
        domain.setUnavailability(entity.getUnavailability());
        domain.setNodeAffected(entity.getNodeAffected());
        domain.setOlt(entity.getOlt());
        domain.setCard(entity.getCard());
        domain.setPort(entity.getPort());
        domain.setCtoAffected(entity.getCtoAffected());
        domain.setCity(entity.getCity());
        domain.setCauseProblem(entity.getCauseProblem());
        domain.setCountClient(entity.getCountClient());
        domain.setBadPraxis(entity.getBadPraxis());
        domain.setSolutions(entity.getSolutions());
        domain.setCloseTicketmasterAt(entity.getCloseTicketmasterAt());
        domain.setBreakDowns(
                entity.getBreakDowns().stream().map(
                        breakdowns-> BreakDownMapper.toDomain(breakdowns)
                ).collect(Collectors.toSet())
        );

        return domain;
    }

    public static SubticketJpaEntity toJpa(Subticket domain) {
        SubticketJpaEntity entity = new SubticketJpaEntity();

        entity.setSubticketId(domain.getSubticketId());
        entity.setSubticketCode(domain.getSubticketCode());
        entity.setStatus(domain.getStatus());
        entity.setCommentary(domain.getCommentary());
        entity.setManagerAt(domain.getManagerAt());
        entity.setReport(domain.getReport());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setCreateAtEvent(domain.getCreateAtEvent());
        entity.setReportPext(domain.getReportPext());
        entity.setEndAtEvent(domain.getEndAtEvent());
        entity.setDateStopLabores(domain.getDateStopLabores());
        entity.setDateStartLabores(domain.getDateStartLabores());
        entity.setStopWork(domain.getStopWork());
        entity.setTimeEvent(domain.getTimeEvent());
        entity.setTimeAffected(domain.getTimeAffected());
        entity.setTimeSolutionsEvent(domain.getTimeSolutionsEvent());
        entity.setTimeReportPext(domain.getTimeReportPext());
        entity.setUnavailability(domain.getUnavailability());
        entity.setNodeAffected(domain.getNodeAffected());
        entity.setOlt(domain.getOlt());
        entity.setCard(domain.getCard());
        entity.setPort(domain.getPort());
        entity.setCtoAffected(domain.getCtoAffected());
        entity.setCity(domain.getCity());
        entity.setCauseProblem(domain.getCauseProblem());
        entity.setCountClient(domain.getCountClient());
        entity.setBadPraxis(domain.getBadPraxis());
        entity.setSolutions(domain.getSolutions());
        entity.setCloseTicketmasterAt(domain.getCloseTicketmasterAt());
        entity.setBreakDowns(
                domain.getBreakDowns().stream().map(
                        breakDown -> BreakDownMapper.toEntity(breakDown)
                ).collect(Collectors.toSet())
        );
        return entity;
    }

}
