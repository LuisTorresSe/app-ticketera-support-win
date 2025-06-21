package com.win.app.ticketera.support.win.subticket.application.service;

import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketCommand;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketState;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketUseCase;
import com.win.app.ticketera.support.win.subticket.application.port.out.SubticketPort;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional

public class CreateSubticketService implements CreateSubticketUseCase {

    private final SubticketPort subticketPort;
    private final TicketPort ticketPort;

    public CreateSubticketService(SubticketPort subticketPort, TicketPort ticketPort) {
        this.subticketPort = subticketPort;
        this.ticketPort = ticketPort;
    }

    @Override
    public Subticket createSubticket(CreateSubticketCommand command) {

        Ticket findTicket = ticketPort.findById(command.getTicketId()).orElseThrow(
                () -> new IllegalArgumentException("Ticket not found")
        );


        Subticket newSubticket = Subticket.builder()
                .badPraxis(command.getBadPraxis())
                .card(command.getCard())
                .causeProblem(command.getCauseProblem())
                .city(command.getCity())
                .createAtEvent(command.getCreateAtEvent())
                .closeTicketmasterAt(command.getCloseTicketmasterAt())
                .commentary(command.getCommentary())
                .countClient(command.getCountClient())
                .ctoAffected(command.getCtoAffected())
                .dateStartLabores(command.getDateStartLabores())
                .dateStopLabores(command.getDateStopLabores())
                .diagnosis(command.getDiagnosis())
                .endAtEvent(command.getEndAtEvent())
                .managerAt(command.getManagerAt())
                .nodeAffected(command.getNodeAffected())
                .olt(command.getOlt())
                .unavailability(command.getUnavailability())
                .status(command.getStatus())
                .report(command.getReport())
                .reportPext(command.getReportPext())
                .stopWork(command.getStopWork())
                .timeEvent(command.getTimeEvent())
                .timeAffected(command.getTimeAffected())
                .timeSolutionsEventPext(command.getTimeSolutionsEventPext())
                .timeReportPext(command.getTimeReportPext())
                .solutions(command.getSolutions())
                .responsable(command.getResponsable())
                .port(command.getPort())
                .subticketCode(findTicket.getCodeTicket() + (findTicket.getSubTickets().size() + 1))
                .ticket(findTicket)
                .breakDowns(null)
                .build();

        Subticket saveSubticket = subticketPort.saveSubticket(newSubticket);

        return saveSubticket;
    }
}
