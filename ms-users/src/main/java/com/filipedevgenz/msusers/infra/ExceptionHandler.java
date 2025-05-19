package com.filipedevgenz.msusers.infra;

import com.filipedevgenz.msusers.dto.ErrorMessage;
import com.filipedevgenz.msusers.exceptions.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessage handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        return new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getBindingResult().getAllErrors().getFirst().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFound.class)
    public ErrorMessage handleUserNotFound(final UserNotFound ex) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
