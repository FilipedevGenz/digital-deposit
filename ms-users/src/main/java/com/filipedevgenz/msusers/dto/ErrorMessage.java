package com.filipedevgenz.msusers.dto;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

public record ErrorMessage(int status, String message) {

    public ErrorMessage userNotFound(int status,String message){
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(),message);
    }
}
