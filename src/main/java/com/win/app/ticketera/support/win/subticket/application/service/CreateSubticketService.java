package com.win.app.ticketera.support.win.subticket.application.service;

import com.win.app.ticketera.support.win.client.application.exception.ClientsNotFound;
import com.win.app.ticketera.support.win.client.application.port.out.ClientPort;
import com.win.app.ticketera.support.win.client.domain.Client;
import com.win.app.ticketera.support.win.subticket.application.exception.ExistingCtoWithSubticket;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketCommand;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketState;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketUseCase;
import com.win.app.ticketera.support.win.subticket.application.port.out.SubticketPort;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import com.win.app.ticketera.support.win.ticket.application.exception.TicketNotFound;
import com.win.app.ticketera.support.win.ticket.application.port.out.TicketPort;
import com.win.app.ticketera.support.win.ticket.domain.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Transactional
@Service
public class CreateSubticketService implements CreateSubticketUseCase {

    private final SubticketPort subticketPort;
    private final TicketPort ticketPort;
    private final ClientPort clientPort;
    public CreateSubticketService(SubticketPort subticketPort,
                                  TicketPort ticketPort,
                                  ClientPort clientPort) {
        this.subticketPort = subticketPort;
        this.ticketPort = ticketPort;
        this.clientPort = clientPort;
    }

    @Override
    public Subticket createSubticket(CreateSubticketCommand command) {

        Ticket findTicket = ticketPort.findById(command.getTicketId()).orElseThrow(
                () -> new TicketNotFound("Ticket not found")
        );

       clientPort.getClientsByCto(command.getCtoAffected()).orElseThrow(
                ()-> new ClientsNotFound("cto don't exists")
        );

       Set<Subticket> existCtoPending = subticketPort.getSubticketByCtoAndStatusPending(command.getCtoAffected());



        if(!existCtoPending.isEmpty()) {
            throw new ExistingCtoWithSubticket("Existing Cto pending for cto: " + command.getCtoAffected());
        }


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
                .statusSubticket(command.getStatus())
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
