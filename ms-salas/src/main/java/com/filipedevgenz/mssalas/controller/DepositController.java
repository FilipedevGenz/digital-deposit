package com.filipedevgenz.mssalas.controller;

import com.filipedevgenz.mssalas.dto.DepositDto;
import com.filipedevgenz.mssalas.model.Deposit;
import com.filipedevgenz.mssalas.model.Thing;
import com.filipedevgenz.mssalas.services.DepositServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deposit")
public class DepositController {
    DepositServices service;

    @PostMapping()
    public ResponseEntity Savedeposit(@RequestBody DepositDto deposit) {
        service.AddDeposit(deposit);
        String s = "http://ms-deposit/deposit";
        URI uri = URI.create(s);
        return ResponseEntity.created(uri).body(deposit);
    }

    @PostMapping("/insert/{num}/local/{}")
    public ResponseEntity Savedeposit(@RequestBody Thing thing, @PathVariable String num, @PathVariable String local) {
        service.SetThing(thing)
    }
    @GetMapping("/all")
    public ResponseEntity<List<Deposit>> Getdeposit() {
    List<Deposit> deposits = service.GetAllDeposits();
    return ResponseEntity.ok().body(deposits);
    }

}
