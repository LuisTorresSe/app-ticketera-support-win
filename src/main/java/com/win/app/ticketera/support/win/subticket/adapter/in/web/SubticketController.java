package com.win.app.ticketera.support.win.subticket.adapter.in.web;

import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketCommand;
import com.win.app.ticketera.support.win.subticket.application.port.in.CreateSubticketUseCase;
import com.win.app.ticketera.support.win.subticket.domain.Subticket;
import com.win.app.ticketera.support.win.ticket.adapter.in.web.RequestCreateTicketDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/subticket" )
public class SubticketController {
    private final CreateSubticketUseCase createSubticketUseCase;
    public SubticketController(CreateSubticketUseCase createSubticketUseCase) {
        this.createSubticketUseCase = createSubticketUseCase;
    }

    @PostMapping
    ResponseEntity<Subticket> createSubTicket(@RequestBody RequestCreateSubticketDto request){
        CreateSubticketCommand command = CreateSubticketCommand.builder()
                .ticketId(request.ticketId())
                .managerAt(request.managerAt())
                .report(request.report())
                .diagnosis(request.diagnosis())
                .createAtEvent(request.createAtEvent())
                .reportPext(request.reportPext())
                .endAtEvent(request.endAtEvent())
                .dateStopLabores(request.dateStopLabores())
                .dateStartLabores(request.dateStartLabores())
                .stopWork(request.stopWork())
                .timeEvent(request.timeEvent())
                .timeAffected(request.timeAffected())
                .timeSolutionsEventPext(request.timeSolutionsEventPext())
                .timeReportPext(request.timeReportPext())
                .unavailability(request.unavailability())
                .nodeAffected(request.nodeAffected())
                .olt(request.olt())
                .card(request.card())
                .port(request.port())
                .ctoAffected(request.ctoAffected())
                .city(request.city())
                .causeProblem(request.causeProblem())
                .countClient(request.countClient())
                .badPraxis(request.badPraxis())
                .solutions(request.solutions())
                .closeTicketmasterAt(request.closeTicketmasterAt())
                .status(request.status())
                .commentary(request.commentary())
                .responsable(request.responsable())
                .breakDownCommands(null)
                .build();

        System.out.println(request.ticketId()+ "esto es command");
            Subticket createdSubticket = createSubticketUseCase.createSubticket(command);


        return new ResponseEntity<>(createdSubticket, HttpStatus.CREATED);
    }

}
