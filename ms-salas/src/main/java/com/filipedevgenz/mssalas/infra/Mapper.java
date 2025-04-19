package com.filipedevgenz.mssalas.infra;

import com.filipedevgenz.mssalas.dto.DepositDto;
import com.filipedevgenz.mssalas.model.Deposit;

public class Mapper {
    public static Deposit ToEntity(DepositDto deposit) {
        String depositId = deposit.local() + deposit.number();
        Deposit toReturn =  new Deposit();
        toReturn.setLocal(deposit.local());
        toReturn.setNumber(deposit.number());
        toReturn.setDepositId(depositId);
        return toReturn;
    }
}
