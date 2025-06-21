package com.win.app.ticketera.support.win.ticket.adapter.out.exception;

import com.win.app.ticketera.support.win.subticket.application.exception.ExistingCtoWithSubticket;
import com.win.app.ticketera.support.win.ticket.application.exception.TicketNotFound;
import com.win.app.ticketera.support.win.utils.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.win.app.ticketera.support.win.ticket.adapter.in.web")
public class TicketExceptionHandler {
    @ExceptionHandler(TicketNotFound.class)

    public ResponseEntity<ApiErrorResponse> ticketNotFound(TicketNotFound e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse("TICKET_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
