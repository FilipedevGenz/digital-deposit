package com.filipedevgenz.mssalas.controller;

import com.filipedevgenz.mssalas.dto.DepositDto;
import com.filipedevgenz.mssalas.model.Deposit;
import com.filipedevgenz.mssalas.model.Thing;
import com.filipedevgenz.mssalas.services.DepositServices;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/deposit")
@Validated
public class DepositController {
    DepositServices service;

    @PostMapping()
    public ResponseEntity<DepositDto> savedeposit(@RequestBody @Valid DepositDto depositDto) {

        //FAZER COM QUE userIdString, nao pegue o nome e sim o userID
        //TODO
        
        String userIdString = SecurityContextHolder.getContext().getAuthentication().getName();
        UUID userId = UUID.fromString(userIdString);
        service.addDeposit(depositDto,userId);

        String depositId = depositDto.local()+ depositDto.number();
        String s = "http://ms-deposit/deposit/" + depositId;
        URI uri = URI.create(s);
        return ResponseEntity.created(uri).body(depositDto);
    }

    @PostMapping("/insert/{num}/local/{local}")
    public ResponseEntity<Thing> insertThing(
            @RequestBody @Valid Thing thing,
            @PathVariable @NotBlank(message = "can't be blank") String num,
            @PathVariable @NotBlank(message = "can't be blank") String local ){
        String s = "http://ms-deposit/deposit";
        URI uri = URI.create(s);
        return ResponseEntity.created(uri).body(service.insertThingIntoDeposit(thing,local + num));
    }

    @PatchMapping("/move/{thingId}/local/{local}")
    public ResponseEntity<Thing> moveThing(
            @PathVariable @NotBlank String thingId,
            @PathVariable @NotBlank String local){
        String s = "http://ms-deposit/deposit";
        URI uri = URI.create(s);
        //TODO
        return ResponseEntity.created(uri).body(service.);
    }

    @GetMapping("/all/{id}")
    //TODO
    public ResponseEntity<List<Deposit>> getAllDeposits(Authentication authentication) {
        authentication.getPrincipal().
    List<Deposit> deposits = service.GetAllDeposits(userUUID);
    return ResponseEntity.ok().body(deposits);
    }

    @GetMapping("/thing/{id}")
    public ResponseEntity<List<Deposit>> getThing() {
        //TODO
        List<Deposit> deposits = service.GetAllDeposits();
        return ResponseEntity.ok().body(deposits);
    }

    @GetMapping("/deposit/{id}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable @NotBlank String id) {
        //TODO
        return ResponseEntity.ok().body(service.getDepositById(id,userUUID));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void  > deleteDeposit(@PathVariable @NotBlank String id) {
        service.RemoveDeposit(id);
        return ResponseEntity.noContent().build();
    }
}
