package com.filipedevgenz.mssalas.dto;

import com.filipedevgenz.mssalas.model.Deposit;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DepositDto(

        @NotEmpty
        @NotNull
        String number,
        @NotEmpty
        @NotNull
        String local
)
{
        public static Deposit toEntity(DepositDto deposit) {
                Deposit toReturn =  new Deposit();
                toReturn.setLocal(deposit.local());
                toReturn.setNumber(deposit.number());
                return toReturn;
        }
}
