package com.win.app.ticketera.support.win.subticket.adapter.out.exception;

import com.win.app.ticketera.support.win.client.application.exception.ClientsNotFound;
import com.win.app.ticketera.support.win.subticket.application.exception.ExistingCtoWithSubticket;
import com.win.app.ticketera.support.win.subticket.application.exception.SubticketNotFound;
import com.win.app.ticketera.support.win.ticket.application.exception.TicketNotFound;
import com.win.app.ticketera.support.win.utils.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.win.app.ticketera.support.win.subticket")
public class SubticketExceptionHandler {
    @ExceptionHandler(SubticketNotFound.class)
    public ResponseEntity<ApiErrorResponse> subticketNotFound(SubticketNotFound e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse("SUBTICKET_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ExistingCtoWithSubticket.class)
    public ResponseEntity<ApiErrorResponse> existingCto(ExistingCtoWithSubticket e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse("EXISTING_CTO", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TicketNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleTicketNotFound(TicketNotFound e) {
        ApiErrorResponse error = new ApiErrorResponse("TICKET_NOT_FOUND", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(ClientsNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(ClientsNotFound e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse("CLIENTS_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
