package com.filipedevgenz.mssalas.services;

import com.filipedevgenz.mssalas.dto.DepositDto;
import com.filipedevgenz.mssalas.exceptions.DepositNotFoundException;
import com.filipedevgenz.mssalas.model.Deposit;
import com.filipedevgenz.mssalas.model.Thing;
import com.filipedevgenz.mssalas.repository.DepositRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DepositServices {

    DepositRepository repository;

    public Thing insertThingIntoDeposit(Thing thing, String depositId) {

        Deposit deposit = repository.findById(depositId)
                .orElseThrow(DepositNotFoundException::new);

        thing.setDeposit(deposit);
        deposit.getThings()
                .add(thing);

        return thing;
    }

    public Deposit addDeposit(DepositDto DTOdeposit, UUID userId) {
        Deposit deposit = DepositDto.toEntity(DTOdeposit);
        deposit.setUserId(userId);
        return repository.save(deposit);
    }

    public Deposit getDepositById(String depositId, UUID userId) {
        Deposit deposit = repository.findById(depositId).orElseThrow(DepositNotFoundException::new);
        if(deposit.getUserId() == userId){
            return deposit;
        }
        throw new DepositNotFoundException();
    }

    public List<Deposit> GetAllDeposits(UUID userId) {
        List<Deposit> toReturn = repository.getDepositsByUserId(userId).orElseThrow(DepositNotFoundException::new);
        return repository.findAll();
    }

    public void RemoveDeposit(String depositId) {
        Deposit toRemove = getDepositById(depositId);
        repository.delete(toRemove);
    }
}