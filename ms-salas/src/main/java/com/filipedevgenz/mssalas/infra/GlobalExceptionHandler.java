package com.filipedevgenz.mssalas.infra;

import com.filipedevgenz.mssalas.exceptions.DepositNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(DepositNotFoundException.class)
    public ResponseEntity<RestErrorMessage> depositNotFound(DepositNotFoundException ex) {
    RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(threatResponse);
}
}
