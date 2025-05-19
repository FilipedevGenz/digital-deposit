package com.filipedevgenz.mssalas.infra;

import com.filipedevgenz.mssalas.exceptions.DepositNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(DepositNotFoundException.class)
    public ResponseEntity<RestErrorMessage> DepositNotFound(DepositNotFoundException ex) {
    RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(threatResponse);
}

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestErrorMessage> ConstraintViolation(ConstraintViolationException ex) {
        RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(threatResponse);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<RestErrorMessage> DataAccess(DataAccessException ex) {
    RestErrorMessage threatResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(threatResponse);
    }


}
