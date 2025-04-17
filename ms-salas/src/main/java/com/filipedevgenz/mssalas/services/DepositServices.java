package com.filipedevgenz.mssalas.services;

import com.filipedevgenz.mssalas.exceptions.DepositNotFoundException;
import com.filipedevgenz.mssalas.model.Deposit;
import com.filipedevgenz.mssalas.model.Thing;
import com.filipedevgenz.mssalas.repository.DepositRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DepositServices {

    DepositRepository repository;

    public Thing SetThing(@Valid Thing thing, UUID depositId) {

        Deposit deposit = repository.findById(depositId)
                .orElseThrow(DepositNotFoundException::new);

        thing.setDeposit(deposit);
        deposit.getThings()
                .add(thing);

        return thing;
    }
}
