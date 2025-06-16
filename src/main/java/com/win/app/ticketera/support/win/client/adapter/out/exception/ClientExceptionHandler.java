package com.win.app.ticketera.support.win.client.adapter.out.exception;

import com.win.app.ticketera.support.win.client.application.exception.ClientsNotFound;
import com.win.app.ticketera.support.win.utils.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.win.app.ticketera.support.win.client")
public class ClientExceptionHandler {

@ExceptionHandler(ClientsNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(ClientsNotFound e) {
        ApiErrorResponse errorResponse = new ApiErrorResponse("CLIENTS_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
