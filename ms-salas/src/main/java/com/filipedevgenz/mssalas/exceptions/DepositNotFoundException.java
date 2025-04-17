package com.filipedevgenz.mssalas.exceptions;

public class DepositNotFoundException extends RuntimeException {
    public DepositNotFoundException() {
        super("Deposit not found");
    }
}
