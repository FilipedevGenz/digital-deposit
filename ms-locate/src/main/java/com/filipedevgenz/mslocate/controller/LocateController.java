package com.filipedevgenz.mslocate.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class LocateController{

    @PatchMapping("/move/{thingId}/local/{local}")
    public ResponseEntity moveThing(
            @PathVariable @NotBlank String thingId,
            @PathVariable @NotBlank String local){
        //TODO
        return ResponseEntity.noContent().build();
    }
}
