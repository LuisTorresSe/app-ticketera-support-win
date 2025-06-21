package com.win.app.ticketera.support.win.subticket.adapter.out.persistence;

import com.win.app.ticketera.support.win.breakdown.adapter.out.persistence.BreakDownMapper;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import com.win.app.ticketera.support.win.ticket.adapter.out.persistence.TicketMapper;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class SubticketMapper {

    public static Subticket toDomain(SubticketJpaEntity entity) {
        Subticket domain = new Subticket();
        domain.setSubticketId(entity.getSubticketId());
        domain.setSubticketCode(entity.getSubticketCode());
        domain.setStatusSubticket(entity.getStatus());
        domain.setCommentary(entity.getCommentary());
        domain.setManagerAt(entity.getManagerAt());
        domain.setReport(entity.getReport());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setCreateAtEvent(entity.getCreateAtEvent());
        domain.setReportPext(entity.getReportPext());
        domain.setEndAtEvent(entity.getEndAtEvent());
        domain.setDateStopLabores(entity.getDateStopLabores());
        domain.setDateStartLabores(entity.getDateStartLabores());
        domain.setStopWork(entity.getStopWork());
        domain.setTimeEvent(entity.getTimeEvent());
        domain.setTimeAffected(entity.getTimeAffected());
        domain.setTimeSolutionsEventPext(entity.getTimeSolutionsEventPext());
        domain.setTimeReportPext(entity.getTimeReportPext());
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
        domain.setTicket(TicketMapper.toDomainWithoutSubticket(entity.getTicket()));
    return domain;
    }


    public static SubticketJpaEntity toJpa(Subticket domain) {
        SubticketJpaEntity entity = new SubticketJpaEntity();
        entity.setSubticketId(domain.getSubticketId());
        entity.setSubticketCode(domain.getSubticketCode());
        entity.setStatus(domain.getStatusSubticket());
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
        entity.setTimeSolutionsEventPext(domain.getTimeSolutionsEventPext());
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
        entity.setTicket(
                TicketMapper.toJpaWithoutSubticket(domain.getTicket())
        );

        return entity;
    }

    /**
     * Convierte a dominio sin incluir la referencia al ticket padre
     * Útil para evitar referencias circulares
     */
    public static Subticket toDomainWithoutTicket(SubticketJpaEntity entity) {
        Subticket domain = new Subticket();
        domain.setSubticketId(entity.getSubticketId());
        domain.setSubticketCode(entity.getSubticketCode());
        domain.setStatusSubticket(entity.getStatus());
        domain.setCommentary(entity.getCommentary());
        domain.setManagerAt(entity.getManagerAt());
        domain.setReport(entity.getReport());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setCreateAtEvent(entity.getCreateAtEvent());
        domain.setReportPext(entity.getReportPext());
        domain.setEndAtEvent(entity.getEndAtEvent());
        domain.setDateStopLabores(entity.getDateStopLabores());
        domain.setDateStartLabores(entity.getDateStartLabores());
        domain.setStopWork(entity.getStopWork());
        domain.setTimeEvent(entity.getTimeEvent());
        domain.setTimeAffected(entity.getTimeAffected());
        domain.setTimeSolutionsEventPext(entity.getTimeSolutionsEventPext());
        domain.setTimeReportPext(entity.getTimeReportPext());
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


        return domain;
    }

    public static SubticketJpaEntity toJpaWithoutTicket(Subticket domain) {
        SubticketJpaEntity entity = new SubticketJpaEntity();
        entity.setSubticketId(domain.getSubticketId());
        entity.setSubticketCode(domain.getSubticketCode());
        entity.setStatus(domain.getStatusSubticket());
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
        entity.setTimeSolutionsEventPext(domain.getTimeSolutionsEventPext());
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


        return entity;
    }

    /**
     * Convierte a JPA sin incluir la referencia al ticket padre
     * Útil para evitar referencias circulares
     */


}